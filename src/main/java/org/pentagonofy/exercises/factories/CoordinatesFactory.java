package org.pentagonofy.exercises.factories;

import org.pentagonofy.exercises.entities.Coordinates;
import org.pentagonofy.exercises.validators.EntityValidatorImpl;

import java.util.List;

public class CoordinatesFactory {

    private CoordinatesFactory() {
        // private constructor to prevent instantiation of this class
    }

    public static Coordinates createCoordinates(float latitude, float longitude) throws IllegalArgumentException {
        Coordinates coords = new Coordinates(latitude, longitude);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(coords);
        if (!errors.isEmpty()) throw new IllegalArgumentException(errors.toString());
        return coords;
    }

    public static class Builder {
        float latitude;
        float longitude;

        public Builder setLatitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public Coordinates build() {
            return createCoordinates(this.latitude, this.longitude);
        }
    }
}
