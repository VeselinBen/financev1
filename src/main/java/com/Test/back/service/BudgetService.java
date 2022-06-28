package com.Test.back.service;

import com.Test.back.model.Budget;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    Optional<Budget> findOne(Long id);

    List<Budget> findAll();

    Page<Budget> findAll(Integer pageNo);

    Budget save(Budget budget);

    Budget update(Budget budget);

    Budget delete(Long budgetId);

    Page<Budget> find(Long budgetId, Long categoryId, Integer pageNo);
}
