package com.finance.accountservice.dto;


import com.finance.accountservice.domain.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountRequestDTO {

    private UUID userId;
    private AccountType accountType;

}
