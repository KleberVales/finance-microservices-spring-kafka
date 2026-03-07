package com.finance.accountservice.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AccountCreatedEvent {

    private UUID accountId;
    private UUID userId;

}
