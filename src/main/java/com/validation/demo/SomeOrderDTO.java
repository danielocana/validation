package com.validation.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@SomeOrderDTOValidation(message = "Is held so write the details")
public class SomeOrderDTO {
    @NotNull(message = "id cant be null")
    private String id;
    @NotNull(message = "Name cant be null")
    private String name;
    @Pattern(regexp = "\\d+", message = "Must be only digits")
    private String phone;
    @SomeValidation(message = "have to be larger than 4")
    private String someField;

    @Past(message = "The date is not in the past")
    private LocalDateTime date;

    private boolean held;
    private String heldDetails;

    public SomeOrderDTO(){}

    public SomeOrderDTO(String id, String name, String phone, String someField, LocalDateTime date, boolean held, String heldDetails) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.someField = someField;
        this.date = date;
        this.held = held;
        this.heldDetails = heldDetails;
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

    public String getSomeField() {
        return someField;
    }

    public boolean isHeld() {
        return held;
    }

    public String getHeldDetails() {
        return heldDetails;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
