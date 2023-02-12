package com.telran.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.bank.entity.Transaction;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Value
public class AccountDTO {

    UUID id;

    String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    String createdAccount;

    String firstName;

    String lastName;

    String country;

    String city;

    BigDecimal amountOfMany;

    List<Transaction> transactions;
}
