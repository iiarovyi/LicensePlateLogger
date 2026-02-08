package org.pentagonofy.exercises.services;

import org.pentagonofy.exercises.entities.Log;
import org.pentagonofy.exercises.entities.Record;
import org.pentagonofy.exercises.exceptions.ReaderException;
import org.pentagonofy.exercises.factories.CoordinatesFactory;
import org.pentagonofy.exercises.factories.RecordsFactory;

import java.nio.file.Path;
import java.sql.*;
import java.util.Objects;

public class H2ReaderImpl implements Reader {


    Log log = new Log();

    String url = "jdbc:h2:./data/LicencePlateTracker-db";
    String username = "sa";
    String password = "";

    @Override
    public void read(Path path) throws ReaderException {
        if(!Objects.isNull(path)) {
            url = path.toString();
        }
        try  (Connection connection = DriverManager.getConnection(url, username, password);
              PreparedStatement ps = connection.prepareStatement("SELECT l.timestamp, l.licencePlate, b.boothtype, b.latitude, b.longitude, b.direction FROM Log l left join Booth b on l.booth_id = b.id");
              ResultSet rs = ps.executeQuery()) {
            StringBuilder sb  = new StringBuilder();
            while(rs.next()) {
                long timestamp = rs.getLong(1);
                String licensePlate = rs.getString(2);
                String boothType = rs.getString(3);
                double latitude = rs.getDouble(4);
                double longitude = rs.getDouble(5);
                String direction = rs.getString(6);

                // load the Log instance with values
                log.addRecord(new RecordsFactory.Builder()
                        .setTimestamp(timestamp)
                        .setLicensePlate(licensePlate)
                        .setBoothType(Record.BoothType.valueOf(boothType))
                        .setCoordinates(new CoordinatesFactory.Builder()
                                .setLongitude((float) longitude)
                                .setLatitude((float)latitude)
                                .build())
                        .setDirection(Record.Direction.valueOf(direction))
                        .build());
            }

        } catch (SQLException e) {
            throw new ReaderException("unable to read from database file: " + e.getMessage());
        }
    }

    @Override
    public Log getLog() {
        return log;
    }
}
