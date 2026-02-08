package org.pentagonofy.exercises.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.entities.Record;

import java.io.IOException;
import java.nio.file.Path;

public class LogFileReaderTest {

    LogReader logReader = new LogReader();

    @Test
    public void readFromFile() throws IOException {
        logReader.readFromFile(Path.of("src/main/resources/smallLog.log"));
        Log log = logReader.getLog();
        IO.println(log.toString());
        Assertions.assertEquals(6, log.size());
        Assertions.assertEquals(Record.BoothType.ENTRY, log.records().getFirst().boothType());
    }
}
