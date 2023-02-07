package com.telran.bank.dto;

import lombok.Value;
import java.util.UUID;

@Value
public class AccountDTO {

    UUID id;

    String email;

    String createdAccount;

    String firstName;

    String lastName;

    String country;

    String city;

    String amountOfMany;
}
