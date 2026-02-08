package com.pentagonofy.excercises.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = com.pentagonofy.excercises.validators.NotNullValidator.class)
public @interface NotNull {
    String message() default "Value must not be null";
}
