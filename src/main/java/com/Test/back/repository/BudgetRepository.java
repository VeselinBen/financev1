package com.Test.back.repository;

import com.Test.back.model.Budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Page<Budget> findByBudgetIdAndCategoryId(Long budgetId, Long categoryId, Pageable pageable);
}
