package com.finance.accountservice.event.consumer;

import java.math.BigDecimal;
import java.util.UUID;

public class AllowanceApprovedEvent {

    private UUID id;
    private String expenseType;
    private BigDecimal account_amount;

    // Construtor vazio (necessário para deserialização JSON)
    public AllowanceApprovedEvent() {}

    // Construtor completo
    public AllowanceApprovedEvent(UUID id, String expenseType, BigDecimal account_amount) {
        this.id = id;
        this.expenseType = expenseType;
        this.account_amount = account_amount;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public BigDecimal getAccount_amount() {
        return account_amount;
    }

    public void setAccount_amount(BigDecimal account_amount) {
        this.account_amount = account_amount;
    }

    @Override
    public String toString() {
        return "AllowanceApprovedEvent{" +
                "id=" + id +
                ", expenseType='" + expenseType + '\'' +
                ", account_amount=" + account_amount +
                '}';
    }
}

