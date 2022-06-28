package com.Test.back.repository;

import com.Test.back.model.BudgetCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory, Long> {

    Page<BudgetCategory> findByBudgetCategoryId(Long budgetCategoryId, Pageable pageable);
}
