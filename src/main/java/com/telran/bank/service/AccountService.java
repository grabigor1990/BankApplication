
package com.telran.bank.service;

import com.telran.bank.entity.Accounts;
import com.telran.bank.repository.StubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private StubRepository stubRepository;

    public Accounts saveAccount(Accounts account){
        return stubRepository.saveAcount(account);
    }
    public double getBalance(int accountID){
        return StubRepository.findBalanceByAccID(accountID);
    }
    public void depositAmount(int accountId,double amount){
        StubRepository.saveBalanceByAccID(accountId,amount);
    }
    public void withdrawAmount(int accountID,double amount){
        stubRepository.withdrawAmountByAccID(accountID,amount);
    }
    public void teansferAmount(int accountID,int destAccID,double amount){
        stubRepository.withdrawAmountByAccID(accountID, amount);
        stubRepository.saveBalanceByAcctID(destAccID, amount);
    }

    public List<Accounts> getAllAccounts() {
        return null;
    }

    public Accounts getAccount(long id) {
        return null;
    }
}
