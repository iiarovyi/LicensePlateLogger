package org.hexagonofy.exercises.entities;

import org.hexagonofy.exercises.annotations.Max;
import org.hexagonofy.exercises.annotations.Min;

import java.util.Objects;

/**
 * Represents a set of geographic coordinates with latitude and longitude values.
 * This class encapsulates the latitude and longitude coordinates
 * for a specific geographic location. It provides methods to retrieve
 * and update these values.
 * Constructors:
 * - A no-argument constructor to create an uninitialized Coordinates object.
 * - A parameterized constructor to initialize the latitude and longitude directly.
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
    private final float latitude;

    @Min(value = -180.0, message = "Longitude must be >= {value}")
    @Max(value = 180.0, message = "Longitude must be <= {value}")
    private final float longitude;

    // TODO:IIAR this is not validated. Probably should not allow to construct this object using constructor. Use factory instead.
    public Coordinates(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("%.4f,%.4f", latitude, longitude);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Coordinates coordinates && coordinates.latitude == latitude && coordinates.longitude == longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(latitude) + Objects.hashCode(longitude);
    }
}
