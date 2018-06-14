package com.validation.demo;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestingDomainValidation {

    public TestingDomainValidation() { }

    @Test
    public void testMemberWithNoValues() {
        SomeOrderDomain domain = new SomeOrderDomain("67", "pp", "3434");

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<SomeOrderDomain>> violations = validator.validate(domain);
        assertEquals(violations.size(), 1);
    }
}
