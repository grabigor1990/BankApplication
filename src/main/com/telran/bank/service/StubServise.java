
package com.telran.bank.service;

import com.telran.bank.repository.StubRepository;

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
    public void teansferAmount(int accountID,int destAcctID,double amount){
        stubRepository.withdrawAmountByAcctID(accountID, amount);
        stubRepository.saveBalanceByAcctID(destAcctID, amount);
    }

}
