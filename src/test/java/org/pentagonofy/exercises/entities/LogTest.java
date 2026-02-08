package org.pentagonofy.exercises.entities;

import org.pentagonofy.exercises.factories.CoordinatesFactory;
import org.pentagonofy.exercises.factories.RecordsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LogTest {

    private Log log;

    @BeforeEach
    public void setUp() {
        log = new Log();
        log.addRecord(new Record()
                .setBoothType(Record.BoothType.ENTRY)
                .setCoordinates(new Coordinates(45.4321f, 120.1234f))
                .setDirection(Record.Direction.E)
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        log.addRecord(new Record()
                .setBoothType(Record.BoothType.PASS_THROUGH)
                .setCoordinates(new Coordinates(45.4321f, 120.144f))
                .setDirection(Record.Direction.E)
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        log.addRecord(new Record()
                .setBoothType(Record.BoothType.EXIT)
                .setCoordinates(new Coordinates(45.4321f, 120.1254f))
                .setDirection(Record.Direction.E)
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        log.addRecord(new RecordsFactory.Builder()
                .setLicensePlate("TH234N")
                .setBoothType(Record.BoothType.ENTRY)
                .setDirection(Record.Direction.W)
                .setCoordinates(new CoordinatesFactory.Builder().setLatitude(45.4321f).setLongitude(120.1254f).build()).build());
        log.addRecord(RecordsFactory.createRecord("TTT123F", new Date().getTime(), Record.BoothType.EXIT, Record.Direction.W, CoordinatesFactory.createCoordinates(45.4321f, 120.1254f)));
    }

    @Test
    public void checkRecordsAvailable() {
        Assertions.assertEquals(5, log.size());
    }

    @Test
    public void checkFirstRecord() {
        Assertions.assertTrue(log.records().getFirst().toString().contains("ENTRY"));
    }

    @Test
    public void checkLastRecord() {
        Assertions.assertTrue(log.records().getLast().toString().contains("EXIT"));
    }

    @Test
    public void checkRecordValidationThrowsExceptionWhenAddedThroughFactoryWithInvalidRecord() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> log.addRecord(new RecordsFactory.Builder().build()));
        Assertions.assertNotNull(exception.getMessage());
        Assertions.assertFalse(exception.getMessage().isEmpty());
    }
}
