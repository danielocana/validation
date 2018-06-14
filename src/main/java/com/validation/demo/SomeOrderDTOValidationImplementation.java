package com.validation.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SomeOrderDTOValidationImplementation implements ConstraintValidator<SomeOrderDTOValidation, SomeOrderDTO> {

   public void initialize(SomeOrderDTOValidation constraint) {
   }

   public boolean isValid(SomeOrderDTO dto, ConstraintValidatorContext context) {
       if(dto.isHeld()){
           return !dto.getHeldDetails().isEmpty();
       }
       return true;
   }
}
