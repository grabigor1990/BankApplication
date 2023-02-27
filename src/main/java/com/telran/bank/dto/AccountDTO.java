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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    String createdAccount;
    String email;
    String firstName;
    String lastName;
    String country;
    String city;
    String amountOfMoney;
}