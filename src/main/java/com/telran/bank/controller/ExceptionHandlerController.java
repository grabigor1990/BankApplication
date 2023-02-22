package com.telran.bank.controller;

import com.telran.bank.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ResponseStatusException.class)
    public ErrorDTO handleErrors(ResponseStatusException ex) {
        return ErrorDTO.builder()
                .status(ex.getStatus())
                .message(ex.getReason())
                .statusCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO getInputValidationErrorResponse(MethodArgumentNotValidException e) {
        Map<String, List<String>> errors = e.getFieldErrors().stream()
                .collect(Collectors.groupingBy(FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage,
                                Collectors.toList())));
        return ErrorDTO.builder()
                .message("Input validation error")
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .errors(errors.toString())
                .build();
    }
}