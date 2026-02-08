package com.pentagonofy.excercises.validators;

import com.pentagonofy.excercises.annotations.Max;

public class MaxValidator implements ConstraintValidator<Max> {
    @Override
    public boolean isValid(Object value, Max annotation) {
        if (value instanceof Number number) {
            return number.doubleValue() <= annotation.value();
        }
        return false;
    }

    @Override
    public String getMessage(Max annotation) {
        return annotation.message().replace("{value}", String.valueOf(annotation.value()));
    }
}
