package org.pentagonofy.exercises.validators;

import org.pentagonofy.exercises.annotations.Min;

public class MinValidator implements ConstraintValidator<Min> {
    @Override
    public boolean isValid(Object value, Min annotation) {
        if (value instanceof Number number) {
            return number.doubleValue() >= annotation.value();
        }
        return false;
    }

    @Override
    public String getMessage(Min annotation) {
        return annotation.message().replace("{value}", String.valueOf(annotation.value()));
    }
}
