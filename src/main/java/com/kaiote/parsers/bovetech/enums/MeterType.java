package com.kaiote.parsers.bovetech.enums;

public enum MeterType {

    BECOX("BECOX"), B91VW("B91VW");

    private final String type;

    private MeterType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    
}