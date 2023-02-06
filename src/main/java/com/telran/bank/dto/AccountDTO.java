package com.telran.bank.dto;

import lombok.Value;

@Value
public class AccountDTO {

    String email;

    String createdAccount;

    String firstName;

    String lastName;

    String country;

    String city;

    String amountOfMany;
}
