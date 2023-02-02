package com.bnp.inputmodels;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class Zone {
    @JsonValue
    private int index;
    private static final int[][] ZONE_PRICES = new int[][]{
            {240, 240, 280, 300},
            {240, 240, 280, 300},
            {280, 280, 200, 200},
            {300, 300, 200, 200}
    };

    public Zone() {
    }

    public Zone(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Integer computePriceByTrip(Zone zone) {
        return ZONE_PRICES[this.index - 1][zone.index - 1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return index == zone.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
