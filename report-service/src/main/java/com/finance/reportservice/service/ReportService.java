package com.finance.reportservice.service;

import com.finance.reportservice.dto.MonthlyExpenseDTO;
import com.finance.reportservice.event.CardTransactionReceivedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    public void processTransaction(CardTransactionReceivedEvent event) {
    }

    public List<MonthlyExpenseDTO> getMonthlyExpenses() {
        return null;
    }
}
