
package com.telran.bank.service;

import com.telran.bank.repository.StubRepository;
import org.springframework.stereotype.Service;

@Service
public class StubService {
    private StubRepository stubRepository;


    public double getBalance(int accountID){
        return stubRepository.findBalanceByAccID(accountID);
    }
    public void depositAmount(int accountId,double amount){
        stubRepository.saveBalanceByAccID(accountId,amount);
    }
    public void withdrawAmount(int accountID,double amount){
        stubRepository.withdrawAmountByAccID(accountID,amount);
    }
    public void teansferAmount(int accountID,int destAccID,double amount){
        stubRepository.withdrawAmountByAccID(accountID, amount);
        stubRepository.saveBalanceByAcctID(destAccID, amount);
    }

}
