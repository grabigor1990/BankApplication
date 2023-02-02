
package com.telran.bank.controller;

import com.telran.bank.entity.Account;
import com.telran.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;
    @PostMapping
    public Account createAccount(@RequestBody Account account){// check if data valid.
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts(@RequestParam (required = false) List<String> date,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String country){
        return accountService.getAllAccounts(date,city,country);
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable long id){
        return accountService.getAccount(id);
    }
    @GetMapping ("/accountID/balance")
    public ResponseEntity<Double> getBalance(@PathVariable double accountID){
        return accountService.getBalance(accountID);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
