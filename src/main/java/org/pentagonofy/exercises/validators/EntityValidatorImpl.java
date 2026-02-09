package org.pentagonofy.exercises.validators;

import org.pentagonofy.exercises.annotations.Constraint;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityValidatorImpl {

    public record ValidationError(String field, String message) {
        @Override
        public String toString() {
            return field + ": " + message;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<ValidationError> validate(Object obj) {
        List<ValidationError> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            for (Annotation annotation : field.getAnnotations()) {
                Constraint constraint = annotation.annotationType().getAnnotation(Constraint.class);
                if (constraint == null) continue;

                try {
                    var validatorClass = (Class<? extends ConstraintValidator<Annotation>>) constraint.validatedBy();
                    ConstraintValidator<Annotation> validator = validatorClass.getDeclaredConstructor().newInstance();

                    Object value = field.get(obj);
                    if (!validator.isValid(value, annotation)) {
                        errors.add(new ValidationError(field.getName(), validator.getMessage(annotation)));
                    }
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Failed to instantiate validator for @" +
                            annotation.annotationType().getSimpleName(), e);
                }
            }
        }
        return errors;
    }
}
