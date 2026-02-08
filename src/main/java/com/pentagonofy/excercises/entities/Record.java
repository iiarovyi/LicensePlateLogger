package com.pentagonofy.excercises.entities;

import com.pentagonofy.excercises.annotations.Min;
import com.pentagonofy.excercises.annotations.NotNull;

/**
 * Represents a log entry in a vehicle toll system.
 *
 * This class encapsulates data related to a single vehicle's activity
 * in the toll system, including the vehicle's license plate, the timestamp
 * of the entry, the type of toll booth interacted with, and the direction
 * the vehicle was traveling.
 *
 * Fields:
 * - licensePlate: The license plate number of the vehicle.
 * - timestamp: The time when the event occurred, represented as a floating-point number.
 * - boothType: The type of toll booth (e.g., entry, pass-through, exit).
 * - direction: The direction of travel (e.g., N, NE, E, SE, S, SW, W, NW).
 * - coordinates: The geographic coordinates of the vehicle's location at the time of passing the booth.
 */

public class Record {
    @NotNull(message = "License plate is required")
    private String licensePlate;

    @Min(value = 0, message = "Timestamp must be >= {value}")
    private float timestamp;

    @NotNull(message = "Booth type is required")
    private String boothType;

    @NotNull(message = "Direction is required")
    private String direction;

    @NotNull(message = "Coordinates are required")
    private Coordinates coordinates;

    public Record() {
    }

    public Record(String licensePlate, float timestamp, String boothType, String direction, Coordinates coordinates) {
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
        this.boothType = boothType;
        this.direction = direction;
        this.coordinates = coordinates;
    }

    public String licensePlate() {
        return licensePlate;
    }

    public Record setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public float timestamp() {
        return timestamp;
    }

    public Record setTimestamp(float timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String boothType() {
        return boothType;
    }

    public Record setBoothType(String boothType) {
        this.boothType = boothType;
        return this;
    }

    public String direction() {
        return direction;
    }

    public Record setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public Coordinates coordinates() {
        return coordinates;
    }

    public Record setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s, %f, %s, %s, %s", licensePlate, timestamp, boothType, direction, coordinates);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Record entry && entry.licensePlate.equals(licensePlate) && entry.timestamp == timestamp && entry.boothType.equals(boothType) && entry.direction.equals(direction) && entry.coordinates.equals(coordinates);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
