
package com.telran.bank.service.impl;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.entity.Transaction;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.repository.TransactionRepository;
import com.telran.bank.service.AccountSrvice;
import com.telran.bank.service.exception.AccountNotFoundException;
import com.telran.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountSrvice {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public List<AccountDTO> getAllAccount(String date, List<String> city, String sort) {
        return accountMapper.toDtoList(accountRepository.findAll(date,city,sort));
    }

    public AccountDTO createAccount(AccountDTO accountDto){
       Account account = accountMapper.dtoToAccount(accountDto);
        accountRepository.save(account);
       return accountMapper.accountToDto(account);

    }

    public AccountDTO getAccount(Long id) {
      Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountMapper.accountToDto(account);
    }

    public Account updateAccount(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        existingAccount.setEmail(account.getEmail());
        existingAccount.setFirstName(account.getFirstName());
        existingAccount.setLastName(account.getLastName());
        existingAccount.setCountry(account.getCountry());
        existingAccount.setCity(account.getCity());
        existingAccount.setAmountOfMany(account.getAmountOfMany());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
