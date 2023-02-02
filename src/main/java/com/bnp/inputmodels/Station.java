package com.bnp.inputmodels;

import com.bnp.outputmodels.Trip;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Optional;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
public enum Station {
    A(1),
    B(1),
    C(2, 3),
    D(2),
    E(2, 3),
    F(3, 4),
    G(4),
    H(4),
    I(4);
    private Set<Zone> zoneSet;

    Station(Integer ...zoneSet) {
        this(Arrays.asList(zoneSet));
    }
    Station(List<Integer> zoneList) {
        this.zoneSet = zoneList.stream().map(Zone::new).collect(Collectors.toSet());
    }

    public Optional<Trip> FromStartZoneToDestinationZone(Station station) {
        return this.zoneSet.stream()
                .map(startZone -> station.zoneSet.stream()
                        .map(destinationZone -> prepareTrip(station, startZone, destinationZone))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .min(Comparator.comparingDouble(Trip::getCostInCents));
    }
    private Trip prepareTrip(Station station, Zone startZone, Zone destinationZone) {
        Trip trip = new Trip();
        trip.setStationStart(Station.this);
        trip.setStationEnd(station);
        trip.setZoneFrom(startZone);
        trip.setZoneTo(destinationZone);
        trip.setCostInCents(startZone.computePriceByTrip(destinationZone));
        return trip;
    }
}
