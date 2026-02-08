package com.pentagonofy.excercises.factories;

import com.pentagonofy.excercises.entities.Coordinates;
import com.pentagonofy.excercises.validators.EntityValidatorImpl;
import com.pentagonofy.excercises.entities.Record;

import java.util.List;

/**
 * The RecordsFactory class serves as a factory for creating and managing record instances.
 * This class provides a centralized approach for producing record objects
 * that can be used throughout the system. It encapsulates the logic required
 * to construct, validate and configure records, ensuring consistency and reusability.
 */
public class RecordsFactory {

    public static Record createRecord(String licensePlate, float timestamp, String boothType, String direction, Coordinates coordinates) throws IllegalArgumentException {
        Record record = new Record(licensePlate, timestamp, boothType, direction, coordinates);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(record);
        if (!errors.isEmpty()) throw new IllegalArgumentException(errors.toString());
        return record;
    }

    public static class Builder {
        String licensePlate;
        float timestamp;
        String boothType;
        String direction;
        Coordinates coordinates;

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setTimestamp(float timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setBoothType(String boothType) {
            this.boothType = boothType;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Record build() {
            return createRecord(this.licensePlate, this.timestamp, this.boothType, this.direction, this.coordinates);
        }
    }
}
