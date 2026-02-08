package entities;

import com.pentagonofy.excercises.entities.Coordinates;
import com.pentagonofy.excercises.entities.Log;
import com.pentagonofy.excercises.entities.Record;
import com.pentagonofy.excercises.factories.RecordsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LogTest {

    private final Log log = new Log();

    public LogTest () {
        log.addRecord(new Record()
                .setBoothType("ENTRY")
                .setCoordinates(new Coordinates(45.4321f, 120.1234f))
                .setDirection("E")
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        log.addRecord(new Record()
                .setBoothType("PASS-THROUGH")
                .setCoordinates(new Coordinates(45.4321f, 120.144f))
                .setDirection("E")
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        log.addRecord(new Record()
                .setBoothType("EXIT")
                .setCoordinates(new Coordinates(45.4321f, 120.1254f))
                .setDirection("E")
                .setTimestamp(new Date().getTime())
                .setLicensePlate("TNT2K"));
        // Use factory builder for record creation (does also validate records)
        log.addRecord(new RecordsFactory.Builder()
                .setLicensePlate("TH234N")
                .setBoothType("ENTRY")
                .setDirection("W")
                .setCoordinates(new Coordinates(45.4321f, 120.1254f)).build());
        // Use factory method for record creation (does also validate records)
        log.addRecord(RecordsFactory.createRecord("TTT123F", new Date().getTime(), "EXIT", "W", new Coordinates(45.4321f, 120.1254f)));
    }

    @Test
    public void checkRecordsAvailable() {
        assert log.size() == 5;
    }

    @Test
    public void checkFirstRecord() {
        assert log.records().getFirst().toString().contains("ENTRY");
    }

    @Test
    public void checkLastRecord() {
        assert log.records().getLast().toString().contains("EXIT");
    }

    @Test
    public void checkRecordValidationThrowsExceptionWhenAddedThroughFactoryWithInvalidRecord() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> log.addRecord(new RecordsFactory.Builder().build()));
        assert exception.getMessage().equals("[licensePlate: License plate is required, boothType: Booth type is required, direction: Direction is required, coordinates: Coordinates are required]");
    }
}
