package com.telran.bank.service;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    List<AccountDTO> getAllAccount(String date, String city);

    AccountDTO getAccount(UUID id);

    Account updateAccount(UUID id, AccountDTO account);

    AccountDTO createAccount(AccountDTO accountDTO);

    void deleteAccount(UUID id);

    void transfer(Account fromId, Account toId, BigDecimal amount);
}