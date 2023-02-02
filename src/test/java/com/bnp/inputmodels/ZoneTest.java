package com.bnp.inputmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ZoneTest {
    @Test
    void testEquals() {
        Zone zoneOne = new Zone(1);
        Zone zoneTwo = new Zone(2);
        // "identity",
        assertEquals(zoneOne, zoneOne);
        // different zone
        assertFalse(zoneOne.equals(zoneTwo));
    }

    @Test
    public void testHashCode() {
        Zone zoneOne = new Zone(1);
        assertEquals(zoneOne.hashCode(), zoneOne.hashCode());
    }
}