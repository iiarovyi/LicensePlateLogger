package org.pentagonofy.exercises.entities;

import org.pentagonofy.exercises.annotations.Min;
import org.pentagonofy.exercises.annotations.NotNull;

import java.util.Objects;

/**
 * Represents a log entry in a vehicle toll system.
 * This class encapsulates data related to a single vehicle's activity
 * in the toll system, including the vehicle's license plate, the timestamp
 * of the entry, the type of toll booth interacted with, and the direction
 * the vehicle was traveling.
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
    private long timestamp;

    @NotNull(message = "Booth type is required")
    private BoothType boothType;

    @NotNull(message = "Direction is required")
    private Direction direction;

    @NotNull(message = "Coordinates are required")
    private Coordinates coordinates;

    public Record() {
    }

    public Record(String licensePlate, long timestamp, BoothType boothType, Direction direction, Coordinates coordinates) {
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
        this.boothType = boothType;
        this.direction = direction;
        this.coordinates = coordinates;
    }

    public enum BoothType {
        ENTRY, PASS, EXIT
    }

    public enum Direction {
        N, NE, E, SE, S, SW, W, NW
    }

    public String licensePlate() {
        return licensePlate;
    }

    public Record setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public long timestamp() {
        return timestamp;
    }

    public Record setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BoothType boothType() {
        return boothType;
    }

    public Record setBoothType(BoothType boothType) {
        this.boothType = boothType;
        return this;
    }

    public Direction direction() {
        return direction;
    }

    public Record setDirection(Direction direction) {
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
        return String.format("%d  %s  %s  %s  %s", timestamp, licensePlate, boothType, coordinates, direction);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Record entry)) return false;
        return timestamp == entry.timestamp
                && Objects.equals(licensePlate, entry.licensePlate)
                && Objects.equals(boothType, entry.boothType)
                && Objects.equals(direction, entry.direction)
                && Objects.equals(coordinates, entry.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, timestamp, boothType, direction, coordinates);
    }
}
