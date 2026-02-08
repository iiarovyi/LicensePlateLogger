package com.pentagonofy.excercises.entities;

import com.pentagonofy.excercises.annotations.Max;
import com.pentagonofy.excercises.annotations.Min;

/**
 * Represents a set of geographic coordinates with latitude and longitude values.
 *
 * This class encapsulates the latitude and longitude coordinates
 * for a specific geographic location. It provides methods to retrieve
 * and update these values.
 *
 * Constructors:
 * - A no-argument constructor to create an uninitialized Coordinates object.
 * - A parameterized constructor to initialize the latitude and longitude directly.
 *
 * Methods:
 * - latitude(): Retrieves the current latitude value.
 * - setLatitude(float latitude): Sets the latitude value and returns the updated Coordinates object.
 * - longitude(): Retrieves the current longitude value.
 * - setLongitude(float longitude): Sets the longitude value and returns the updated Coordinates object.
 * - toString(): Returns a string representation of the Coordinates in the format "[latitude,longitude]".
 */
public class Coordinates {
    @Min(value = -90.0, message = "Latitude must be >= {value}")
    @Max(value = 90.0, message = "Latitude must be <= {value}")
    private float latitude;

    @Min(value = -180.0, message = "Longitude must be >= {value}")
    @Max(value = 180.0, message = "Longitude must be <= {value}")
    private float longitude;

    public Coordinates() {
    }

    public Coordinates(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float latitude() {
        return latitude;
    }

    public Coordinates setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float longitude() {
        return longitude;
    }

    public Coordinates setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[%.4f,%.4f]", latitude, longitude);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Coordinates coordinates && coordinates.latitude == latitude && coordinates.longitude == longitude;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(latitude) + Float.hashCode(longitude);
    }
}
