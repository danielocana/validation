package com.validation.demo;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class SomeService {

    private ValidatorFactory validatorFactory;

    public SomeService(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public void insert(SomeNewDTO dto) {
        Set<ConstraintViolation<SomeNewDTO>> validate = validatorFactory.getValidator().validate(dto);
        log.info("errors {} ", validate);
    }

    public String insert(SomeOrderDTO dto) {
        SomeOrderDomain someOrderDomain = new SomeOrderDomain(dto.getId(), dto.getName(), dto.getPhone());
        List<Error> collect = validatorFactory.getValidator().validate(someOrderDomain).stream()
                .map(x -> new Error(x.getMessage(), x.getPropertyPath().toString()))
                .collect(Collectors.toList());

        if(!collect.isEmpty()){
            throw new ErrorsOnDomain(collect);
        }

        ZonedDateTime ldtZoned = dto.getDate().atZone(ZoneId.systemDefault());

        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
        return utcZoned.toString();
    }
}
