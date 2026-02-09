package org.pentagonofy.exercises.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordTest {

    private static final long FIXED_TIMESTAMP = 1700000000000L;
    private final Record logEntry = new Record("UHV12XT", FIXED_TIMESTAMP, Record.BoothType.ENTRY, Record.Direction.W, new Coordinates(90.0f, 123.1234f));

    @Test
    public void checkClassPropertiesAvailable() {
        Assertions.assertEquals("UHV12XT", logEntry.licensePlate());
        Assertions.assertEquals(FIXED_TIMESTAMP, logEntry.timestamp());
        Assertions.assertEquals(Record.BoothType.ENTRY, logEntry.boothType());
        Assertions.assertEquals(Record.Direction.W, logEntry.direction());
        Assertions.assertEquals(new Coordinates(90.0f, 123.1234f), logEntry.coordinates());
    }

    @Test
    public void checkCorrectnessOfEqualsAndHashCode() {
        Record other = new Record("UHV12XT", FIXED_TIMESTAMP, Record.BoothType.ENTRY, Record.Direction.W, new Coordinates(90.0f, 123.1234f));
        Assertions.assertEquals(logEntry, other);
        Assertions.assertEquals(logEntry.hashCode(), other.hashCode());
    }
}
