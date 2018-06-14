package com.validation.demo;

import java.util.List;

public class ErrorResponse {
    private List<Error> errors;

    public ErrorResponse(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
