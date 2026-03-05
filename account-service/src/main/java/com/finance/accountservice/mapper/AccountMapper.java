package com.finance.accountservice.mapper;

import com.finance.accountservice.domain.Account;
import com.finance.accountservice.dto.AccountRequestDTO;
import com.finance.accountservice.dto.AccountResponseDTO;
import com.finance.accountservice.domain.AccountStatus;

import java.math.BigDecimal;

public class AccountMapper {

    public static Account toEntity(AccountRequestDTO dto) {

        return Account.builder()
                .userId(dto.getUserId())
                .accountType(dto.getAccountType())
                .balance(BigDecimal.ZERO)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }

    public static AccountResponseDTO toDTO(Account account) {

        return AccountResponseDTO.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .balance(account.getBalance())
                .accountType(account.getAccountType())
                .accountStatus(account.getAccountStatus())
                .build();
    }

}
