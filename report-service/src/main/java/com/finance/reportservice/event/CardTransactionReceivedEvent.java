package com.finance.reportservice.event;

import java.math.BigDecimal;
import java.util.UUID;

public class CardTransactionReceivedEvent {

    private UUID account_id;
    private BigDecimal debit;

}
