package com.bnp.outputmodels;

import com.bnp.inputmodels.Station;
import com.bnp.inputmodels.Zone;

import java.time.Instant;

public class Trip {
    private Station stationStart;
    private Station stationEnd;
    private Instant startedJourneyAt;
    private Integer costInCents;
    private Zone zoneFrom;
    private Zone zoneTo;

    public Station getStationStart() {
        return stationStart;
    }

    public void setStationStart(Station stationStart) {
        this.stationStart = stationStart;
    }

    public Station getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(Station stationEnd) {
        this.stationEnd = stationEnd;
    }

    public Instant getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public void setStartedJourneyAt(Instant startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public Integer getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(Integer costInCents) {
        this.costInCents = costInCents;
    }

    public Zone getZoneFrom() {
        return zoneFrom;
    }

    public void setZoneFrom(Zone zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public Zone getZoneTo() {
        return zoneTo;
    }

    public void setZoneTo(Zone zoneTo) {
        this.zoneTo = zoneTo;
    }
}
