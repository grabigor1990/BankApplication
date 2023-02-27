package com.telran.bank.util;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.dto.TransactionDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoCreator {

    public static TransactionDTO getTransactionDTO(
            String id, String type, String accountFrom,
            String accountTo, String amount, String dateTime) {
        return new TransactionDTO(id, type, accountFrom, accountTo, amount, dateTime);
    }

    public static TransactionDTO createDefaultTransactionDto() {
        return getTransactionDTO(
                "4",
                "WITHDRAW",
                "account1",
                "account2",
                "100.00",
                "2020-01-01"
        );
    }

    public static TransactionDTO createTransactionDto1() {
        return getTransactionDTO(
                "4",
                "TRANSFER",
                "d8a6a52c-8361-4d51-8a8d-fcdd2f7f26b9",
                "12d72b50-1c7b-4f45-9bc1-ea9e9a95c8d5",
                "123400.0",
                "2023-03-03"
        );
    }
    public static TransactionDTO createTransactionDto2() {
        return getTransactionDTO(
                "5",
                "WITHDRAW",
                "d8a6a52c-8361-4d51-8a8d-fcdd2f7f26b9",
                "d8a6a52c-8361-4d51-8a8d-fcdd2f7f26b9",
                "100.00",
                "2023-04-04"
        );
    }

    public static AccountDTO getAccountDTO(
            String id, String createdAccount, String email,String firstName, String lastName, String country, String city,
            String amountOfMany) {
        return new AccountDTO(id,createdAccount,email, firstName, lastName, country, city, amountOfMany);
    }

    public static AccountDTO createAccountDto1() {
        return getAccountDTO(
                "d8a6a52c-8361-4d51-8a8d-fcdd2f7f26b9",
                "2021-05-05",
                "john.doe@example.com",
                "John",
                "Doe",
                "USA",
                "New York",
                "1000.00");
    }
    public static AccountDTO createAccountDto2() {
        return getAccountDTO(
                "12d72b50-1c7b-4f45-9bc1-ea9e9a95c8d5",
                "2020-02-02",
                "does.doe@example.com",
                "Anna",
                "Does",
                "USA",
                "Boston",
                "2000.00");
    }
}
