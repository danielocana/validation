package com.validation.demo;

import lombok.*;

import java.util.Arrays;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Data
public class SomeNewDTO {

    @ContainsKeys(message = "the message map", values = {"ORDER_ID", "ACCOUNT_ID"})
    private Map<String, String> sMap;

    private Map<String, Integer> iMap;
}
