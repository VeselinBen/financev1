package com.Test.back.service.impl;

import com.Test.back.model.Budget;
import com.Test.back.model.BudgetCategory;
import com.Test.back.repository.BudgetRepository;
import com.Test.back.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class JpaBudgetService implements BudgetService {

    private BudgetRepository budgetRepository;

    @Override
    public Optional<Budget> findOne(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Page<Budget> findAll(Integer pageNo) {
        return budgetRepository.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Budget update(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Budget delete(Long budgetId) {
        Optional<Budget> budget = budgetRepository.findById(budgetId);
        if(budget.isPresent()){
            budgetRepository.deleteById(budgetId);
            return budget.get();
        }
        return null;
    }

    @Override
    public Page<Budget> find(Long budgetId, Long categoryId, Integer pageNo) {
        return budgetRepository.findByBudgetIdAndCategoryId(budgetId, categoryId, PageRequest.of(pageNo, 5));
    }
}
