package com.finance.planningservice.repository;

import com.finance.planningservice.domain.ExpenseType;
import com.finance.planningservice.domain.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanningRepository extends JpaRepository<Planning, UUID> {

    Planning findPlanningByExpenseType(ExpenseType expenseType);


}
