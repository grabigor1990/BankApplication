
package com.telran.bank.controller;

import com.telran.bank.entity.Accounts;
import com.telran.bank.exception.AccountNotFoundException;
import com.telran.bank.repository.AccountRepository;
import com.telran.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/accounts")
    public Accounts createAccount(@RequestBody Accounts account){// check if data valid.
        return accountService.createAccount(account);
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccounts(@RequestParam (required = false) List<String> date,
                                         @RequestParam(required = false) String city,
                                         @RequestParam(required = false) String country){
        return accountService.getAllAccounts(date,city,country);
    }
    @PatchMapping("/accaunt/{id}")


    @GetMapping("/accounts/{id}")
    public Optional<Accounts> getAccount(@PathVariable long id){
        return accountService.getAccount(id);
    }
    @GetMapping ("/accountID/balance")
    public double getBalance(@PathVariable int accountID){
        return accountService.getBalance(accountID);
    }

    @PutMapping("/{id}")
    public Accounts updateAccount(@PathVariable Long id, @RequestBody Accounts account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
