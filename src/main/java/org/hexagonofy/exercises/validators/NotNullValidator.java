package org.hexagonofy.exercises.validators;

import org.hexagonofy.exercises.annotations.NotNull;

public class NotNullValidator implements ConstraintValidator<NotNull> {
    @Override
    public boolean isValid(Object value, NotNull annotation) {
        return value != null;
    }

    @Override
    public String getMessage(NotNull annotation) {
        return annotation.message();
    }
}
