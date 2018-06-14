package com.validation.demo;

public class Error {
    private String theError;
    private String field;

    public Error(String theError, String field) {
        this.theError = theError;
        this.field = field;
    }

    public String getTheError() {
        return theError;
    }

    public String getField() {
        return field;
    }
}
