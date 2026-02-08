import com.pentagonofy.excercises.entities.Coordinates;
import com.pentagonofy.excercises.entities.LogEntry;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LogEntryTest {

    private LogEntry logEntry = new LogEntry("UHV12XT", new Date().getTime(), "ENTRY", "W", new Coordinates(90.1234f, 123.1234f));

    @Test
    public void checkClassPropertiesAvailable () throws AssertionError{

        assert logEntry.licensePlate().equals("UHV12XT");
        assert logEntry.timestamp() == new Date().getTime();
        assert logEntry.boothType().equals("ENTRY");
        assert logEntry.direction().equals("W");
        assert logEntry.coordinates().equals(new Coordinates(90.1234f, 123.1234f));
    }

    @Test
    public void checkCorrectnessOfEqualsAndHashCode () throws AssertionError {
        assert logEntry.equals(new LogEntry("UHV12XT", new Date().getTime(), "ENTRY", "W", new Coordinates(90.1234f, 123.1234f)));
    }
}
