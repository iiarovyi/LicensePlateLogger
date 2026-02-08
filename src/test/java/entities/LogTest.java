package entities;

import com.pentagonofy.excercises.entities.Coordinates;
import com.pentagonofy.excercises.entities.Log;
import com.pentagonofy.excercises.entities.Record;
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
    }

    @Test
    public void checkRecordsAvailable() {
        assert log.size() == 3;
    }

    @Test
    public void checkFirstRecord() {
        assert log.records().getFirst().toString().contains("ENTRY");
    }

    @Test
    public void checkLastRecord() {
        assert log.records().getLast().toString().contains("EXIT");
    }
}
