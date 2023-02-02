package com.telran.bank.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class AccountDTO {
    private Long id;
    private String email;
    private LocalDateTime createdAccount;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private BigDecimal amountOfMany;
}
