package com.finance.accountservice.dto;

import com.finance.accountservice.domain.AccountStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class AccountResponseDTO {

    private UUID id;
    private UUID userId;
    private BigDecimal creditLimit;
    private BigDecimal usedAmount;
    private BigDecimal availableLimit;
    private AccountStatus accountStatus;

}
