package org.pentagonofy.exercises.validators;

import org.pentagonofy.exercises.annotations.NotNull;

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
