package com.validation.demo;

import javax.validation.constraints.Size;

public class SomeOrderDomain {

    private String id;
    @Size( min = 4, message = "the name have to be larger than 4")
    private String name;
    private String phone;

    public SomeOrderDomain(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
