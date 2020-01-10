package com.validation.demo;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class ContainsKeysImpl implements ConstraintValidator<ContainsKeys, Map<String, String>> {
    String[] requiredKeys;

    @Override
    public void initialize(ContainsKeys constraintAnnotation) {
        requiredKeys = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Map<String, String> value, ConstraintValidatorContext context) {
        return StringUtils.isEmpty(value.get("ORDER_ID"));
    }
}
