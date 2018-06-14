package com.validation.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SomeValidationImplementation implements ConstraintValidator<SomeValidation, String> {

    @Override
    public void initialize(SomeValidation constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() > 2;
    }
}
