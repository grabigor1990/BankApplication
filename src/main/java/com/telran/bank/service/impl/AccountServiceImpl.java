
package com.telran.bank.service;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.service.exception.AccountNotFoundException;
import com.telran.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountSrvice {


    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final TransactionService transactionService;



    public List<AccountDTO> getAllAccount(@RequestParam(required = false) String date,
                                        @RequestParam(required = false) List<String> city,
                                        @RequestParam(required = false) String sort) {
        return accountMapper.toDtoList(accountRepository.findAll(date,city,sort));   //accountRepository.findAll();
    }

    public Account saveAccount(Account accounts){
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



    @Override
    public AccountDTO getAccount(Long id) {
        return null;
    }
}
