package com.bnp.inputmodels;

import java.time.Instant;

public class Tap {
    private Instant unixTimestamp;
    private Integer customerId;
    private Station station;
    public Instant getUnixTimestamp() {
        return unixTimestamp;
    }
    public void setUnixTimestamp(Instant unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Station getStation() {
        return station;
    }
    public void setStation(Station station) {
        this.station = station;
    }
}
