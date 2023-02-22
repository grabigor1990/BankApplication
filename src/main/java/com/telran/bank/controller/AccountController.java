package com.telran.bank.controller;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.service.AccountSrvice;
import com.telran.bank.validation.Uuid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountSrvice accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts(@RequestParam(value = "date", required = false) String date,
                                           @RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "sort", required = false) String sort) {
        return accountService.getAllAccount(date, city, sort);
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount(@Uuid @PathVariable UUID id) {
        return accountService.getAccount(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@Uuid @PathVariable UUID id, @RequestBody AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@Uuid @PathVariable UUID id) {
        accountService.deleteAccount(id);
    }
}