package com.telran.bank.service;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountSrvice {

    List<AccountDTO> getAllAccount(String date, List<String> city,String sort);

    AccountDTO getAccount(Long id);

    Account updateAccount(Long id, Account account);

    AccountDTO createAccount(AccountDTO accountDTO);

    void deleteAccount(Long id);

}
