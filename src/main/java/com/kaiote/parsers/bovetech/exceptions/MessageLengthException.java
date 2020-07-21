package com.kaiote.parsers.bovetech.exceptions;

public class MessageLengthException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MessageLengthException() {
        super("The Message is not the right size");
    }
}