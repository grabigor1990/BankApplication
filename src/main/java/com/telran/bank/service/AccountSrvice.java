package com.telran.bank.service;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;

import java.util.List;
import java.util.UUID;

public interface AccountSrvice {

    List<AccountDTO> getAllAccount(String date, List<String> city, String sort);

    AccountDTO getAccount(UUID id);

    Account updateAccount(UUID id, AccountDTO account);

    AccountDTO createAccount(AccountDTO accountDTO);

    void deleteAccount(UUID id);

}
