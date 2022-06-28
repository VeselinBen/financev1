package com.Test.back.service;

import com.Test.back.model.BudgetCategory;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BudgetCategoryService {
    Optional<BudgetCategory> findOne(Long id);

    List<BudgetCategory> findAll();

    Page<BudgetCategory> findAll(Integer pageNo);

    BudgetCategory save(BudgetCategory budgetCategory);

    BudgetCategory update(BudgetCategory budgetCategory);

    BudgetCategory delete(Long budgetId);

    Page<BudgetCategory> find(Long budgetId, Integer pageNo);
}
