package com.finance.reportservice.controller;

import com.finance.reportservice.dto.MonthlyExpenseDTO;
import com.finance.reportservice.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private ReportService reportService;

    @GetMapping("/monthly-expenses")
    public List<MonthlyExpenseDTO> getMonthlyExpenses() {
        return reportService.getMonthlyExpenses();
    }
}
