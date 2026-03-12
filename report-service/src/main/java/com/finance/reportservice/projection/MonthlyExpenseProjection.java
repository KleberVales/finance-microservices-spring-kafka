package com.finance.reportservice.projection;

import java.math.BigDecimal;

public interface MonthlyExpenseProjection {

    BigDecimal getTotal();

    Integer getMonth();
}