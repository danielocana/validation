package com.validation.demo;

import javax.validation.ValidatorFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SomeService {

    private ValidatorFactory validatorFactory;

    public SomeService(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
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
