package com.kaiote.parsers;

import com.kaiote.parsers.data.Meter;
import com.kaiote.parsers.enums.CommunicationProtocol;
import com.kaiote.parsers.enums.MeterType;
import com.kaiote.parsers.exceptions.MessageLengthException;
import com.kaiote.parsers.utils.SigfoxHandler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class BoveTech {

    private Meter meter;

    /**
     * 
     * @param meterHex
     * @param meterId
     * @param communicationProtocol
     * @throws MessageLengthException
     */
    public BoveTech(String meterHex, String meterId, CommunicationProtocol communicationProtocol, MeterType meterType,
            Boolean valveOpen) throws MessageLengthException {
        meter = new Meter(meterHex, meterId, communicationProtocol, meterType);
        if (communicationProtocol.equals(CommunicationProtocol.SIGFOX)) {
            SigfoxHandler handler = new SigfoxHandler(meter);
            this.meter = handler.loadMeter();
        }

        if (Boolean.TRUE.equals(valveOpen)) {
            this.meter.setDownlinkData("00000404A0170055");
        } else {
            this.meter.setDownlinkData("00000404A0170099");
        }
    }
}