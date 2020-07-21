package com.kaiote.parsers.bovetech.utils;

import com.kaiote.parsers.bovetech.data.Meter;
import com.kaiote.parsers.bovetech.enums.ValveState;
import com.kaiote.parsers.bovetech.exceptions.MessageLengthException;
import com.kaiote.parsers.bovetech.helpers.Separator;
import com.kaiote.parsers.bovetech.interfaces.NetworkHandler;

public class SigfoxHandler implements NetworkHandler<Meter> {

    private final String[] allAlerts = { "Low battery Alarm", "Reverse Flow Alarm", "Over Range Alarm",
            "Over Temprature Alarm", "EEPROM Error", "Transducer In Error", "Transducer OUT Error" };

    private Meter meter;

    private Separator separator;

    public SigfoxHandler(Meter boveMeter) throws MessageLengthException {
        this.meter = boveMeter;
        this.separator = new Separator(boveMeter.getMeterHex());
        this.extractVolumeData();
        this.extractIntervalData();
        this.extractMeterValveData();
        this.extractMeterErrorData();
    }

    public Meter loadMeter(){
        return this.meter;
    }

    /**
     * @param volumeData
     * @return
     */
    public void extractVolumeData() {
        String volumeData = this.separator.getVolumeData();
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < volumeData.length(); i += 2) {
            bld.append(volumeData.substring((volumeData.length() - i) - 2, (volumeData.length() - i)));
        }
        Double volume = Double.valueOf(bld.toString());
        this.meter.setMeterReading(volume);
    }

    /**
     * @param intervalData
     * @return
     */
    public void extractIntervalData() {
        String intervalData = this.separator.getInterval();
        Integer sendingFrequency = Integer.parseInt(intervalData, 16);
        this.meter.setSendingInterVal(sendingFrequency);
    }

    /**
     * @param stateData
     * @return
     */
    public void extractMeterValveData() {
        String stateData = this.separator.getMeterState();
        String valveData = stateData.substring(2, 4);
        ValveState valveState = ValveState.VALVERROR;
        if (valveData.equals("00")) {
            valveState = ValveState.OPENED;
        } else if (valveData.equals("01")) {
            valveState = ValveState.CLOSED;
        } else if (valveData.equals("11")) {
            valveState = ValveState.VALVERROR;
        }
        this.meter.setValveState(valveState);
    }

    /**
     * @param stateData
     * @return
     */
    public void extractMeterErrorData() {
        String stateData = this.separator.getMeterState();
        String state2 = stateData.substring(0, 2);
        Integer valveState = Integer.parseInt(state2, 16);
        char[] alertsBin = String.format("%8s", Integer.toBinaryString(valveState)).replace(" ", "0").toCharArray();
        String[] currentAlarms = new String[1];
        for (int i = allAlerts.length - 1; i >= 0; i--) {
            if (alertsBin[i] == '1') {
                currentAlarms[i] = this.allAlerts[i];
            }
        }
        this.meter.setAlerts(currentAlarms);
    }

    public Meter openValve() {
        return null;
    }

    public Meter closeValve() {
        return null;
    }

}