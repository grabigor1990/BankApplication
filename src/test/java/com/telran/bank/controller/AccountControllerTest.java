package com.telran.bank.controller;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.service.AccountService;
import com.telran.bank.util.DtoCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void testCreateAccount() {
        AccountDTO accountDTO = DtoCreator.createAccountDto1();
        AccountDTO expectedAccountDTO = DtoCreator.createAccountDto2();
        when(accountService.createAccount(any(AccountDTO.class))).thenReturn(expectedAccountDTO);

        AccountDTO result = accountController.createAccount(accountDTO);

        assertNotNull(result);
        assertEquals(expectedAccountDTO, result);
        verify(accountService, times(1)).createAccount(any(AccountDTO.class));
    }

    @Test
    void testGetAllAccounts() {
        String date = "2022-02-28";
        String city = "Berlin";
        List<AccountDTO> expectedAccountDTOs = new ArrayList<>();
        when(accountService.getAllAccount(date, city)).thenReturn(expectedAccountDTOs);

        List<AccountDTO> result = accountController.getAllAccounts(date, city);

        assertNotNull(result);
        assertEquals(expectedAccountDTOs, result);
        verify(accountService, times(1)).getAllAccount(date, city);
    }

    @Test
    void testGetAccount() {
        UUID id = UUID.randomUUID();
        AccountDTO expectedAccountDTO = DtoCreator.createAccountDto1();
        when(accountService.getAccount(id)).thenReturn(expectedAccountDTO);

        AccountDTO result = accountController.getAccount(id);

        assertNotNull(result);
        assertEquals(expectedAccountDTO, result);
        verify(accountService, times(1)).getAccount(id);
    }

    @Test
    void testUpdateAccount() {
        UUID id = UUID.randomUUID();
        AccountDTO accountDTO = DtoCreator.createAccountDto1();
        Account expectedAccount = new Account();
        when(accountService.updateAccount(id, accountDTO)).thenReturn(expectedAccount);

        Account result = accountController.updateAccount(id, accountDTO);

        assertNotNull(result);
        assertEquals(expectedAccount, result);
        verify(accountService, times(1)).updateAccount(id, accountDTO);
    }

    @Test
    void testDeleteAccount() {
        UUID id = UUID.randomUUID();

        accountController.deleteAccount(id);

        verify(accountService, times(1)).deleteAccount(id);
    }
}