package com.kaiote.parsers.bovetech.enums;

public enum MeterAlert {
    
    BATTERY("Low Battery Alarm"),
    PIPE("Empty Pipe Alarm"),
    FLOW("Reverse Flow Alarm"),
    RANGE("Over Range Alarm"),
    TEMPERATURE("Over Temperature Alarm"),
    EEPROM("EEPROM error"),
    TRANSDUCERIN("Transducer In Error"),
    TRANSDUCEROUT("Transducer Out Error");

    private final String alert;

    private MeterAlert(String alert) {
        this.alert = alert;
    }

    public String getType() {
        return alert;
    }

}