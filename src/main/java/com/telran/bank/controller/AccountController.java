
package com.telran.bank.controller;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.service.AccountSrvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<AccountDTO> getAllAccounts(@RequestParam (value = "date", required = false) String date,
                                        @RequestParam(value = "city", required = false) List <String> city,
                                        @RequestParam(value = "sort", required = false) String sort){
        return accountService.getAllAccount(date,city,sort);
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
