package com.kaiote.parsers.bovetech.enums;

public enum ValveState {

    OPENED("OPENED"), CLOSED("CLOSED"), VALVERROR("VALVERROR");

    private final String state;

    private ValveState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}