package com.bank.mapper;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;

public class AccountMapper {
    private AccountMapper(){

    }

    public static Account AccountDTOToAccount(AccountDto dto){
        Account account = new Account();
        account.setId(dto.id());
        account.setAccountHolderName(dto.accountHolderName());
        account.setBalance(dto.balance());
        return account;
    }
    public static AccountDto AccountToAccountDTO(Account account){
        AccountDto dto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
        return dto;
    }
}
