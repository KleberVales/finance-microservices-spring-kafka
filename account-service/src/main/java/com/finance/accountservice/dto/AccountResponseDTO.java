package com.finance.accountservice.dto;

import com.finance.accountservice.domain.AccountStatus;
import com.finance.accountservice.domain.AccountType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class AccountResponseDTO {

    private UUID id;
    private UUID userId;
    private BigDecimal balance;
    private AccountType accountType;
    private AccountStatus accountStatus;

}
