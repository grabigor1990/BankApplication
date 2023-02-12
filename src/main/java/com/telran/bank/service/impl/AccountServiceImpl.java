
package com.telran.bank.service.impl;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.service.AccountSrvice;
import com.telran.bank.service.exception.AccountNotFoundException;
import com.telran.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountSrvice {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public List<AccountDTO> getAllAccount(String date, List<String> city, String sort) {
        return accountMapper.toDtoList(accountRepository.findAll(date, city, sort));
    }

    public AccountDTO createAccount(AccountDTO accountDto) {
        Account account = accountMapper.dtoToAccount(accountDto);
        accountRepository.save(account);
        return accountMapper.accountToDto(account);

    }

    public AccountDTO getAccount(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountMapper.accountToDto(account);
    }

    public Account updateAccount(UUID id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        existingAccount.setEmail(accountDTO.getEmail());
        existingAccount.setFirstName(accountDTO.getFirstName());
        existingAccount.setLastName(accountDTO.getLastName());
        existingAccount.setCountry(accountDTO.getCountry());
        existingAccount.setCity(accountDTO.getCity());
        existingAccount.setAmountOfMany(accountDTO.getAmountOfMany());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }

}
