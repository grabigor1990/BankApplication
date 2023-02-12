package com.telran.bank.service.impl;

import com.telran.bank.entity.annotation.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UuidConstraint implements ConstraintValidator<UUID.Uuid, String> {

    private static final String UUID_PATTERN = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}$";

    @Override
    public void initialize(UUID.Uuid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Optional.ofNullable(value)
                .filter(s -> !s.isBlank())
                .map(s -> s.matches(UUID_PATTERN))
                .orElse(false);
    }
}
