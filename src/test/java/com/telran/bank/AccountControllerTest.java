package com.telran.bank;

import com.telran.bank.controller.AccountController;
import com.telran.bank.entity.Accounts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

@SpringBootTest
public class AccountControllerTest {
    @Autowired
    private AccountController accountController;

    @Test
    public void testCreateAccount() {
        Accounts account = new Accounts();
        Accounts createdAccount = accountController.createAccount(account);
        assertNotNull(createdAccount);

    }

    @Test
    public void testGetAllAccounts() {
        List<Accounts> accounts = accountController.getAllAccounts(null, null, null);
        assertNotNull(accounts);
    }

    @Test
    public void testGetAccount() {
        Optional<Accounts> account = accountController.getAccount(1);
        assertTrue(account.isPresent());

    }

}

