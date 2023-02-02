
package com.telran.bank.service;

import com.telran.bank.entity.Account;
import com.telran.bank.exception.AccountNotFoundException;
import com.telran.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(@RequestParam(required = false) List<String> date,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String sort) {
        return accountRepository.findAll();
    }

    public Account createAccount(Account accounts){
        return accountRepository.save(accounts);
    }

    public Optional<Account> getAccount(long id) {
        return accountRepository.findById(id);
    }

    public ResponseEntity<Double> getBalance(double accountID) {
        return null;
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
