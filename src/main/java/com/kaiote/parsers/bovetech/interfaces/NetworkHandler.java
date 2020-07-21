package com.kaiote.parsers.bovetech.interfaces;

public interface NetworkHandler<T> {

    public void extractVolumeData();

    public void extractIntervalData();

    public void extractMeterValveData();

    public void extractMeterErrorData();

    public T loadMeter();

    public T openValve();

    public T closeValve();
}