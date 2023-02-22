package com.telran.bank.util;

import com.telran.bank.entity.Account;
import com.telran.bank.entity.Transaction;
import com.telran.bank.entity.enums.TransactionType;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class EntityCreator {

   public Account getAccount1(){
       Account account1 = new Account();
            account1.setId( UUID.fromString("d8a6a52c-8361-4d51-8a8d-fcdd2f7f26b9"));
            account1.setEmail(" john.doe@example.com");
            account1.setFirstName("John");
            account1.setLastName("Doe");
            account1.setCountry("US");
            account1.setCity("New York");
            account1.setAmountOfMany(BigDecimal.valueOf(10021.00));
            return account1;
   }

    public Account getAccount2(){
        Account account2 = new Account();
        account2.setId( UUID.fromString("12d72b50-1c7b-4f45-9bc1-ea9e9a95c8d5"));
        account2.setFirstName("Anna");
        account2.setLastName("Does");
        account2.setEmail(" does.doe@example.com");
        account2.setCountry("US");
        account2.setCity("Boston");
        account2.setAmountOfMany(BigDecimal.valueOf(10344.00));
        return account2;
    }

    public Transaction getTransaction1(){
        Transaction transaction1 = new Transaction(WITHDRAW, fromId, toId, amount);
        transaction1.setId(UUID.randomUUID());
        transaction1.setType(TransactionType.TRANSFER);
        transaction1.setAccountFrom(String.valueOf(getAccount1().getId()));
        transaction1.setAccountTo(String.valueOf(getAccount2().getId()));
        transaction1.setAmount(BigDecimal.valueOf(123400.00));
        return transaction1;
    }

    public Transaction getTransaction2(){
        Transaction transaction2 = new Transaction(WITHDRAW, fromId, toId, amount);
        transaction2.setId(UUID.randomUUID());
        transaction2.setType(TransactionType.WITHDRAW);
        transaction2.setAccountFrom(String.valueOf(getAccount1().getId()));
        transaction2.setAccountTo(String.valueOf(getAccount1().getId()));
        transaction2.setAmount(BigDecimal.valueOf(100.00));
        return transaction2;
    }

    public Transaction getTransaction3(){
        Transaction transaction3 = new Transaction(WITHDRAW, fromId, toId, amount);
        transaction3.setId(UUID.randomUUID());
        transaction3.setType(TransactionType.DEPOSIT);
        transaction3.setAccountFrom(String.valueOf(getAccount2().getId()));
        transaction3.setAccountTo(String.valueOf(getAccount2().getId()));
        transaction3.setAmount(BigDecimal.valueOf(200.00));
        return transaction3;
    }
}
