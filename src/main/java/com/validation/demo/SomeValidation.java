package com.validation.demo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = SomeValidationImplementation.class)
public @interface SomeValidation {

    String message()  default "Must be a well-formed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
