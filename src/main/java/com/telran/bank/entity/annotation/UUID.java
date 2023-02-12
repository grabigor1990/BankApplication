package com.telran.bank.entity.annotation;

import com.telran.bank.service.impl.UuidConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

public @interface UUID {

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {UuidConstraint.class})
    public @interface Uuid {

        String message() default "Invalid UUID format";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
}
