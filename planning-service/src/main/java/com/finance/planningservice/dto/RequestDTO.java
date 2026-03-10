package com.finance.planningservice.dto;

import com.finance.planningservice.domain.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RequestDTO {

    private UUID id;
    private ExpenseType expenseType;
    private BigDecimal account_amount;

}
