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
                .creditLimit(BigDecimal.ZERO)
                .usedAmount(BigDecimal.ZERO)
                .availableLimit(BigDecimal.ZERO)
                .status(AccountStatus.ACTIVE)
                .build();
    }

    public static AccountResponseDTO toDTO(Account account) {

        return AccountResponseDTO.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .creditLimit(account.getCreditLimit())
                .availableLimit(account.getAvailableLimit())
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }

}
