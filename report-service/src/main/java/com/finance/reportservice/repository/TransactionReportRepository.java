package com.finance.reportservice.repository;

import com.finance.reportservice.domain.TransactionReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionReportRepository
        extends JpaRepository<TransactionReport, UUID> {
}
