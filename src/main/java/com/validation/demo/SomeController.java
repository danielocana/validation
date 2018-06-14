package com.validation.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api/orders")
public class SomeController {

    private SomeService someService;

    public SomeController(SomeService someService) {
        this.someService = someService;
    }

    @PostMapping
    public String insertOrder (@Valid @RequestBody SomeOrderDTO someOrderDTO) {
        return someService.insert(someOrderDTO);
    }
}
