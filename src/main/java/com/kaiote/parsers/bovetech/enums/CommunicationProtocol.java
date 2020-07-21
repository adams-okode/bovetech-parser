package com.kaiote.parsers.bovetech.enums;

public enum CommunicationProtocol {

    SIGFOX("SIGFOX"), LORA("LORA"), GSM("GSM");

    private final String protocol;

    private CommunicationProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }

}