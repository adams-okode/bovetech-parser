package com.kaiote.parsers.bovetech;

import com.kaiote.parsers.bovetech.data.Meter;
import com.kaiote.parsers.bovetech.enums.CommunicationProtocol;
import com.kaiote.parsers.bovetech.exceptions.MessageLengthException;
import com.kaiote.parsers.bovetech.utils.SigfoxHandler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class Bove {

    private Meter meter;

    /**
     * 
     * @param meterHex
     * @param meterId
     * @param communicationProtocol
     * @throws MessageLengthException
     */
    public Bove(String meterHex, String meterId, CommunicationProtocol communicationProtocol)
            throws MessageLengthException {
        meter = new Meter(meterHex, meterId, communicationProtocol);
        if (communicationProtocol.equals(CommunicationProtocol.SIGFOX)) {
            SigfoxHandler handler = new SigfoxHandler(meter);
            this.meter = handler.loadMeter();
        }
    }


    public static void main(String[] args) {
        try {
            Bove bove = new Bove("6812563413016801020000d3", "242352", CommunicationProtocol.SIGFOX);
            System.out.println(bove.getMeter());
        } catch (MessageLengthException e) {
            e.printStackTrace();
        }

    }
}