package com.bnp.inputmodels;

import com.bnp.outputmodels.Trip;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StationTest {

    private Map<Pair<String, String>, Integer> buildPricesMap() {
        Map<Pair<String, String>, Integer> pricesMap = new HashMap<>();
        pricesMap.put(new Pair<>("A", "B"), 240);
        pricesMap.put(new Pair<>("A", "C"), 240);
        pricesMap.put(new Pair<>("A", "F"), 280);
        pricesMap.put(new Pair<>("A", "I"), 300);
        pricesMap.put(new Pair<>("I", "A"), 300);
        pricesMap.put(new Pair<>("F", "A"), 280);
        pricesMap.put(new Pair<>("E", "G"), 200);
        pricesMap.put(new Pair<>("G", "E"), 200);
        return pricesMap;
    }

    @Test
    void shouldComputeThePriceBetweenA_B() {
        // Given
        Station station_a = Station.A;
        Station station_b = Station.B;
        // When
        Trip result = station_a.FromStartZoneToDestinationZone(station_b).get();
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStationStart()).isEqualTo(station_a);
        assertThat(result.getStationEnd()).isEqualTo(station_b);
        assertThat(result.getCostInCents()).isEqualTo(buildPricesMap().get(new Pair<>(station_a.name(), station_b.name())));
    }

    @Test
    void shouldComputeThePriceBetweenA_C() {
        // Given
        Station station_a = Station.A;
        Station station_c = Station.C;
        // When
        Trip result = station_a.FromStartZoneToDestinationZone(station_c).get();
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStationStart()).isEqualTo(station_a);
        assertThat(result.getStationEnd()).isEqualTo(station_c);
        assertThat(result.getCostInCents()).isEqualTo(buildPricesMap().get(new Pair<>(station_a.name(), station_c.name())));
    }

}