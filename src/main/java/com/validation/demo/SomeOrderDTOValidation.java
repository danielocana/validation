package com.validation.demo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SomeOrderDTOValidationImplementation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SomeOrderDTOValidation {

    String message()  default "write the message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
