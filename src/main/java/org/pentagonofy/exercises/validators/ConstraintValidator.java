package org.pentagonofy.exercises.validators;

import java.lang.annotation.Annotation;

public interface ConstraintValidator<A extends Annotation> {
    boolean isValid(Object value, A annotation);
    String getMessage(A annotation);
}
