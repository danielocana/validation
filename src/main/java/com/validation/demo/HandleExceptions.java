package com.validation.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class HandleExceptions{

    @ExceptionHandler(value = ErrorsOnDomain.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleErrorsOnDomain(ErrorsOnDomain errors) {
        return new ErrorResponse(errors.getCollect());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException errors) {

        return new ErrorResponse(errors.getBindingResult().getAllErrors().stream()
                .map(objectError -> new Error(objectError.getDefaultMessage(), objectError.getObjectName()))
                .collect(Collectors.toList()));
    }
}
