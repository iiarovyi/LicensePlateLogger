package entities;

import com.pentagonofy.excercises.entities.Coordinates;
import com.pentagonofy.excercises.validators.EntityValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CoordinatesTest {

    private Coordinates coordinates = new Coordinates(89.1234f, 123.4567f);

    @Test
    public void checkMethodsChainCorrectly() {
        // Also checks formatting of output string for coordinates
        Assertions.assertEquals("[20.1234,180.0000]", coordinates.setLatitude(20.1234f).setLongitude(180.0000f).toString());
    }

    @Test
    public void checkValidEastBoundForLongitude() {
        Coordinates valid = new Coordinates(0.0f, 180.0f);
        Assertions.assertTrue(EntityValidatorImpl.validate(valid).isEmpty());

        Coordinates invalid = new Coordinates(0.0f, 181.0f);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(invalid);
        // TODO remove
        IO.println(errors);
        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertTrue(errors.stream().anyMatch(e -> e.field().equals("longitude")));
    }

    @Test
    public void checkValidWestBoundForLongitude() {
        Coordinates valid = new Coordinates(0.0f, -180.0f);
        Assertions.assertTrue(EntityValidatorImpl.validate(valid).isEmpty());

        Coordinates invalid = new Coordinates(0.0f, -181.0f);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(invalid);
        // TODO remove
        IO.println(errors);
        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertTrue(errors.stream().anyMatch(e -> e.field().equals("longitude")));
    }

    @Test
    public void checkValidNorthBoundForLatitude() {
        Coordinates valid = new Coordinates(90.0f, 0.0f);
        Assertions.assertTrue(EntityValidatorImpl.validate(valid).isEmpty());

        Coordinates invalid = new Coordinates(91.0f, 0.0f);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(invalid);
        // TODO remove
        IO.println(errors);
        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertTrue(errors.stream().anyMatch(e -> e.field().equals("latitude")));
    }

    @Test
    public void checkValidSouthBoundForLatitude() {
        Coordinates valid = new Coordinates(-90.0f, 0.0f);
        Assertions.assertTrue(EntityValidatorImpl.validate(valid).isEmpty());

        Coordinates invalid = new Coordinates(-91.0f, 0.0f);
        List<EntityValidatorImpl.ValidationError> errors = EntityValidatorImpl.validate(invalid);
        // TODO remove
        IO.println(errors);
        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertTrue(errors.stream().anyMatch(e -> e.field().equals("latitude")));
    }

}
