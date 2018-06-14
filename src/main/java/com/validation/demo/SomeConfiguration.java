package com.validation.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Configuration
public class SomeConfiguration {

    @Bean
    public ValidatorFactory validatorFactory(){
        return Validation.buildDefaultValidatorFactory();
    }

    @Bean
    public SomeService someService (ValidatorFactory validatorFactory) {
        return  new SomeService(validatorFactory);
    }
}
