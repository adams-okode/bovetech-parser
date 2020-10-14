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
    public BoveTech(String meterHex, String meterId, CommunicationProtocol communicationProtocol, MeterType meterType)
            throws MessageLengthException {
        meter = new Meter(meterHex, meterId, communicationProtocol, meterType);
        if (communicationProtocol.equals(CommunicationProtocol.SIGFOX)) {
            SigfoxHandler handler = new SigfoxHandler(meter);
            this.meter = handler.loadMeter();
        }
    }

    // public static void main(String[] args) {
    //     try {
           
    //         System.out.println(bove.getMeter());
    //     } catch (MessageLengthException e) {
    //         e.printStackTrace();
    //     }

    // }
}