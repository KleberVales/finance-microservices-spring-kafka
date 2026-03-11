package com.finance.accountservice.event.consumer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CardTransactionReceivedEvent {

    private UUID account_id;

    private BigDecimal debit;

    public CardTransactionReceivedEvent(){

    }
    public CardTransactionReceivedEvent(UUID account_id, BigDecimal debit) {
        this.account_id = account_id;
        this.debit = debit;
    }

}
