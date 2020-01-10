package com.validation.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController("/api/orders")
@Slf4j
public class SomeController {

    private SomeService someService;

    public SomeController(SomeService someService) {
        this.someService = someService;
    }

    /*@PostMapping
    public String insertOrder (@Valid @RequestBody SomeOrderDTO someOrderDTO) {
        return someService.insert(someOrderDTO);
    }*/

    @PostMapping
    public String insertOrderV1 (@RequestBody SomeNewDTO someOrderDTO) {
        someOrderDTO.setSMap(new HashMap<String, String>() {{
            put("ORDER_ID", "4");
        }});
        someService.insert(someOrderDTO);
        return "IsValid";
    }
}