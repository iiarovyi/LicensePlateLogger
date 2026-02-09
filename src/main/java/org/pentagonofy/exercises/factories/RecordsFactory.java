package org.pentagonofy.exercises.factories;

import org.pentagonofy.exercises.entities.Coordinates;
import org.pentagonofy.exercises.validators.EntityValidatorImpl;
import org.pentagonofy.exercises.entities.Record;

import java.util.List;

/**
 * The RecordsFactory class serves as a factory for creating and managing record instances.
 * This class provides a centralized approach for producing record objects
 * that can be used throughout the system. It encapsulates the logic required
 * to construct, validate and configure records, ensuring consistency and reusability.
 */
public class RecordsFactory {

    private RecordsFactory() {
        // Prevent instantiation of utility/factory class
    }

    public static Record createRecord(String licensePlate, long timestamp, Record.BoothType boothType, Record.Direction direction, Coordinates coordinates) throws IllegalArgumentException {
        Record record = new Record(licensePlate, timestamp, boothType, direction, coordinates);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(record);
        if (!errors.isEmpty()) throw new IllegalArgumentException(errors.toString());
        return record;
    }

    public static class Builder {
        private String licensePlate;
        private long timestamp;
        private Record.BoothType boothType;
        private Record.Direction direction;
        private Coordinates coordinates;

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setBoothType(Record.BoothType boothType) {
            this.boothType = boothType;
            return this;
        }

        public Builder setDirection(Record.Direction direction) {
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
