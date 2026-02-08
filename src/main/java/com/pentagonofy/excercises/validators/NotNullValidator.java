package com.pentagonofy.excercises.validators;

import com.pentagonofy.excercises.annotations.NotNull;

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
