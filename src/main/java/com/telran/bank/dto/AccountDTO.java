package com.telran.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.bank.validation.Uuid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@AllArgsConstructor
@Data
@Builder
@Value
public class AccountDTO {

    @Uuid
    String id;
    String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    String createdAccount;
    @JsonFormat()
    String firstName;
    String lastName;
    String country;
    String city;
    String amountOfMoney;
}