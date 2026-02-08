package org.pentagonofy.exercises.services;

import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.entities.Record;
import org.pentagonofy.exercises.factories.CoordinatesFactory;
import org.pentagonofy.exercises.factories.RecordsFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LogReader {
    private Log log = new Log();

    public void readFromFile(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] parts = line.trim().split("\\s+");

                long timestamp = Long.parseLong(parts[0]);
                String licensePlate = parts[1];
                Record.BoothType boothType = Record.BoothType.valueOf(parts[2]);

                String[] coords = parts[3].split(",");
                float lat = Float.parseFloat(coords[0]);
                float lon = Float.parseFloat(coords[1]);

                Record.Direction direction = Record.Direction.valueOf(parts[4]);

                // add record to the log

                log.addRecord(new RecordsFactory.Builder()
                        .setTimestamp(timestamp)
                        .setLicensePlate(licensePlate)
                        .setCoordinates(new CoordinatesFactory.Builder()
                                .setLatitude(lat)
                                .setLongitude(lon)
                                .build()
                        )
                        .setDirection(direction)
                        .setBoothType(boothType)
                        .build());
            }
        }
    }

    public Log getLog() throws IOException {
        return log;
    }
}
