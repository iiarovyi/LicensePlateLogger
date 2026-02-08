package org.pentagonofy.exercises.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.entities.Record;
import org.pentagonofy.exercises.exceptions.ReaderException;

import java.nio.file.Path;

public class LogFileReaderTest {

    Reader logReader;

    @Test
    public void readFromFile() throws ReaderException {
        logReader = new LogFileReaderImpl();
        logReader.read(Path.of("src/main/resources/smallLog.log"));
        Log log = logReader.getLog();
        // TODO:IIAR remove
        IO.println(log.toString());
        Assertions.assertEquals(6, log.size());
        Assertions.assertEquals(Record.BoothType.ENTRY, log.records().getFirst().boothType());
    }

    @Test
    public void readFromDB() throws ReaderException {
        logReader = new H2ReaderImpl();
        logReader.read(Path.of("jdbc:h2:./data/LicencePlateTracker-db"));
        Log log = logReader.getLog();
        // TODO:IIAR remove
        IO.println(log.toString());
        Assertions.assertEquals(6, log.size());
        Assertions.assertEquals(Record.BoothType.ENTRY, log.records().getFirst().boothType());
    }
}
