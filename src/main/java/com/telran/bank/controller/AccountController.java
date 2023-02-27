package com.telran.bank.controller;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.service.AccountService;
import com.telran.bank.validation.Uuid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts(@RequestParam(value = "date", required = false) String date,
                                           @RequestParam(value = "city", required = false) String city) {
        return accountService.getAllAccount(date, city);
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

    @PutMapping("/accounts/transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transferMoney(@Uuid @RequestParam(value = "fromId", required = false) Account fromId,
                              @Uuid @RequestParam(value = "toId", required = false) Account toId,
                              @RequestParam(value = "amount", required = false) BigDecimal amount) {
        accountService.transfer(fromId, toId, amount);
    }
}