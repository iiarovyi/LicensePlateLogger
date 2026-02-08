package com.pentagonofy.excercises.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = com.pentagonofy.excercises.validators.MaxValidator.class)
public @interface Max {
    double value();
    String message() default "Value must be <= {value}";
}
