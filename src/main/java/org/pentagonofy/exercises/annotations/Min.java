package org.pentagonofy.exercises.annotations;

import org.pentagonofy.exercises.validators.MinValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MinValidator.class)
public @interface Min {
    double value();
    String message() default "Value must be >= {value}";
}
