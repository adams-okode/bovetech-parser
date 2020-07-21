package com.kaiote.parsers.bovetech.data;

import com.kaiote.parsers.bovetech.enums.CommunicationProtocol;
import com.kaiote.parsers.bovetech.enums.MeterType;
import com.kaiote.parsers.bovetech.enums.ValveState;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meter {

    private String key;

    private String deviceId;

    private String meterHex;

    private MeterType type;

    private CommunicationProtocol protocol;

    private Integer sendingInterVal;

    private Double meterReading;

    private String[] alerts;

    private ValveState valveState;

    public Meter(String meterHex, String meterId, CommunicationProtocol communicationProtocol) {
        this.meterHex = meterHex;
        this.deviceId = meterId;
        this.protocol = communicationProtocol;
    }

}