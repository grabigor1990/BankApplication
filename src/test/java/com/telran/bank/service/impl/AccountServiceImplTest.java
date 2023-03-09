package com.telran.bank.service.impl;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.repository.AccountRepository;
import com.telran.bank.exception.AccountNotFoundException;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    private UUID accountId;
    private Account account;
    private AccountDTO accountDTO;

    @Test
    @DisplayName("Get all accounts should return a list of AccountDTOs")
    void testGetAllAccounts() {
        List<Account> accounts = Arrays.asList(EntityCreator.getAccount1(), EntityCreator.getAccount2());
        Account account1 = EntityCreator.getAccount1();
        Account account2 = EntityCreator.getAccount2();
        AccountDTO accountDTO1 = DtoCreator.createAccountDto1();
        AccountDTO accountDTO2 = DtoCreator.createAccountDto2();

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));
        when(accountRepository.findAllByCreatedAccount(LocalDate.parse("2021-05-05"))).thenReturn(accounts);
        when(accountRepository.findAllByCity("New York")).thenReturn(accounts);
        when(accountMapper.toDtoList(Arrays.asList(account1, account2))).thenReturn(Arrays.asList(accountDTO1, accountDTO2));

        List<AccountDTO> allAccounts = accountService.getAllAccount(null, null);
        Assertions.assertEquals(2, allAccounts.size());
        Assertions.assertEquals(accountDTO1, allAccounts.get(0));
        Assertions.assertEquals(accountDTO2, allAccounts.get(1));

        List<AccountDTO> filteredAccounts = accountService.getAllAccount("2021-05-05", "New York");
        Assertions.assertEquals(2, filteredAccounts.size());
        Assertions.assertEquals(accountDTO1, filteredAccounts.get(0));
    }

    @Test
    public void testGetAllAccountWithNullParameters() {
        List<Account> accounts = Arrays.asList(EntityCreator.getAccount1(), EntityCreator.getAccount2());
        Account account1 = EntityCreator.getAccount1();
        Account account2 = EntityCreator.getAccount2();
        AccountDTO accountDTO1 = DtoCreator.createAccountDto1();
        AccountDTO accountDTO2 = DtoCreator.createAccountDto2();

        when(accountRepository.findAll()).thenReturn(accounts);
        when(accountMapper.toDtoList(Arrays.asList(account1, account2))).thenReturn(Arrays.asList(accountDTO1, accountDTO2));

        List<AccountDTO> allAccounts = accountService.getAllAccount(null, null);
        assertEquals(accounts.size(), allAccounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            assertEquals(accounts.get(i).getCity(), allAccounts.get(i).getCity());
            assertEquals(accounts.get(i).getCreatedAccount().toString(), allAccounts.get(i).getCreatedAccount().toString());
            assertEquals(accounts.get(i).getFirstName(), allAccounts.get(i).getFirstName());
            assertEquals(accounts.get(i).getLastName(), allAccounts.get(i).getLastName());
        }
    }

    @Test
    @DisplayName("Create account should save and return an AccountDTO")
    void testCreateAccount() {
        account = EntityCreator.getAccount1();
        when(accountMapper.dtoToAccount(accountDTO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.accountToDto(account)).thenReturn(accountDTO);

        AccountDTO savedAccountDTO = accountService.createAccount(accountDTO);

        assertEquals(accountDTO, savedAccountDTO);
        verify(accountRepository).save(account);
    }

    @Test
    @DisplayName("Get account should return an AccountDTO for an existing account")
    void testGetAccount() {
        this.accountId = UUID.randomUUID();
        Account account = EntityCreator.getAccount1();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountMapper.accountToDto(account)).thenReturn(accountDTO);

        AccountDTO foundAccountDTO = accountService.getAccount(accountId);

        assertEquals(accountDTO, foundAccountDTO);
    }

    @Test
    @DisplayName("Get account should throw an AccountNotFoundException for a non-existing account")
    void testGetAccountNotFound() {
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.getAccount(accountId));
    }

    @Test
    @DisplayName("Update account should update and return an Account")
    void testUpdateAccount() {
        AccountDTO updatedAccountDTO = DtoCreator.createAccountDto1();
        Account updatedAccount = EntityCreator.getAccount1();

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(updatedAccount));
        when(accountRepository.save(updatedAccount)).thenReturn(updatedAccount);

        Account savedAccount = accountService.updateAccount(accountId, updatedAccountDTO);

        assertNotNull(savedAccount);
        assertEquals(updatedAccount, savedAccount);

        verify(accountRepository).save(updatedAccount);
    }

    @Test
    @DisplayName("Update account should throw an AccountNotFoundException for a non-existing account")
    void testUpdateAccountNotFound() {
        UUID nonExistingAccountId = UUID.randomUUID();
        AccountDTO updatedAccountDTO = DtoCreator.createAccountDto1();

        when(accountRepository.findById(nonExistingAccountId)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.updateAccount(nonExistingAccountId, updatedAccountDTO));
    }

    @Test
    @DisplayName("Delete account should delete an existing account")
    void testDeleteAccount() {
        doNothing().when(accountRepository).deleteById(accountId);

        accountService.deleteAccount(accountId);

        verify(accountRepository).deleteById(accountId);
    }
}