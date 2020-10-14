package com.kaiote.parsers.helpers;

import com.kaiote.parsers.exceptions.MessageLengthException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Separator
 */
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString
public class Separator {

    private String startBit;
    private String volumeData;
    private String interval;
    private String meterState;

    public Separator(String message) throws MessageLengthException {
        this.startBit = this.splitSections(message, 0, 2);
        this.volumeData = this.splitSections(message, 2, 10);
        this.interval = this.splitSections(message, 10, 14);
        this.meterState = this.splitSections(message, 14, 18);
    }

    /**
     * 
     * @param message
     * @param start
     * @param stop
     * @return
     * @throws Exception
     */
    public String splitSections(String message, int start, int stop) throws MessageLengthException {
        String firstnChars;
        if (message.length() >= (stop - start)) {
            firstnChars = message.substring(start, stop);
        } else {
            throw new MessageLengthException();
        }
        return firstnChars;
    }

}
