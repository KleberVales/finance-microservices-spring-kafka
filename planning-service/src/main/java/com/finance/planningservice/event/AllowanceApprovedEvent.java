package com.finance.planningservice.event;

import com.finance.planningservice.domain.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AllowanceApprovedEvent {

    private UUID id;
    private ExpenseType expenseType;
    private BigDecimal account_amount;

}
