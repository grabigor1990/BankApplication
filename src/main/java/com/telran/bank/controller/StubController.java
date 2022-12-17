
package com.telran.bank.controller;

import com.telran.bank.service.StubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StubController {

    private StubService stubService;


    @GetMapping ("/accountID/balance")
    public double getBalance(@PathVariable int accountID){
        return stubService.getBalance(accountID);
    }

    @GetMapping("/accountID/deposit/amount")
    public void depositAmount(@PathVariable int accountId,@PathVariable double amount){
        stubService.depositAmount(accountId,amount);
    }

    @GetMapping("/accountID/withdraw/{amount}")
    public void withdrawAmmount(@PathVariable int accountID,@PathVariable double amount){
        stubService.withdrawAmount(accountID,amount);
    }
    @GetMapping("/accountID/transfer/{destAccID}/{amount}")
    public void transferAmount(@PathVariable int acountID,@PathVariable int destAccID,@PathVariable double amount){
        double initBalanceSender = getBalance(acountID);
        double initBalanceReceiver = getBalance(destAccID);
        stubService.teansferAmount(acountID,destAccID,amount);
    }
}
