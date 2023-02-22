package com.telran.bank.mapper;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO accountToDto(Account account);

    Account dtoToAccount(AccountDTO accountDTO);

    List<AccountDTO> toDtoList(List<Account> accounts);
}