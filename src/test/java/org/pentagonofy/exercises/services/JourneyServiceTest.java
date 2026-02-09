package org.pentagonofy.exercises.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.exceptions.ReaderException;

import java.nio.file.Path;

public class JourneyServiceTest {

    Reader logReader;

    @ParameterizedTest
    @ValueSource(strings = { "src/main/resources/smallLog.log;1", "src/main/resources/mediumLog.log;3" })
    public void totalJourneysCount(String values) throws ReaderException {
        String[] pair = values.split(";");
        String path = pair[0];
        long expected = Long.parseLong(pair[1]);
        setup(Path.of(path));
        Log log = logReader.getLog();
        Assertions.assertEquals(expected, JourneysService.countTotalJourneys(log));
    }

    @ParameterizedTest
    @ValueSource(strings = { "src/main/resources/smallLog.log;{TNT123XT=1}", "src/main/resources/mediumLog.log;{PO123XT=1, ROCK23XT=1, TNT123XT=1}" })
    public void journeysPerLicensePlate(String values) throws ReaderException {
        String[] pair = values.split(";");
        String path = pair[0];
        String expected = pair[1];
        setup(Path.of(path));
        Log log = logReader.getLog();
        Assertions.assertEquals(expected, JourneysService.countJourneysPerLicensePlate(log).toString());
    }

    public void setup(Path path) throws ReaderException {
        logReader = new LogFileReaderImpl();
        try {
            logReader.read(path);
        } catch (ReaderException e) {
            throw new ReaderException("Attempt of file reading have failed: " + e.getMessage());
        }
    }
}
