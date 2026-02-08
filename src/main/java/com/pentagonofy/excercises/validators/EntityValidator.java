package com.pentagonofy.excercises.validators;

import java.util.List;

public interface EntityValidator {
    List<EntityValidatorImpl.ValidationError> validate(Object entity);
}
