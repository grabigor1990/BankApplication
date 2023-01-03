
package com.telran.bank.controller;

import com.telran.bank.entity.Accounts;
import com.telran.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public Accounts createAccount(@RequestBody Accounts account){
        return accountService.saveAccount(account);
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Accounts getAccount(@PathVariable long id){
        return accountService.getAccount(id);
    }
    @GetMapping ("/accountID/balance")
    public double getBalance(@PathVariable int accountID){
        return accountService.getBalance(accountID);
    }

    @GetMapping("/accountID/deposit/amount")
    public void depositAmount(@PathVariable int accountId,@PathVariable double amount){
        accountService.depositAmount(accountId,amount);
    }

    @GetMapping("/accountID/withdraw/{amount}")
    public void withdrawAmmount(@PathVariable int accountID,@PathVariable double amount){
        accountService.withdrawAmount(accountID,amount);
    }
    @GetMapping("/accountID/transfer/{destAccID}/{amount}")
    public void transferAmount(@PathVariable int acountID,@PathVariable int destAccID,@PathVariable double amount){
        double initBalanceSender = getBalance(acountID);
        double initBalanceReceiver = getBalance(destAccID);
        accountService.teansferAmount(acountID,destAccID,amount);
    }
}
