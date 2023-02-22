package com.telran.bank.util;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.dto.TransactionDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoCreator {

        public static TransactionDTO getTransactionDTO(
                String id, String type, String accountFrom,
                String accountTo, String amount, String dateTime){
            return new TransactionDTO(id, type, accountFrom, accountTo, amount, dateTime);
        }

        public static TransactionDTO createDefaultTransactionDto() {
            return getTransactionDTO(
                    "12440847382912",
                    "WITHDRAW",
                    "account1",
                    "account2",
                    "100.00",
                    "2020-01-01@03:40:00"
            );
        }

        public static AccountDTO getAccountDTO(
                String id, String email, String createdAccount,
                String firstName, String lastName, String country, String city,
                String amountOfMany) {
            return new AccountDTO(id, email, createdAccount, firstName, lastName, country, city, amountOfMany);
        }

        public static AccountDTO createDefaultAccountDto() {
            return getAccountDTO("id", "allo@.mail.com", "2020-01-01@03:40:00",
                    "John", "Doe", "USA", "New York", "1000.00");

        }
}
