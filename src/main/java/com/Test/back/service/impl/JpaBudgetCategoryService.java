package com.Test.back.service.impl;

import com.Test.back.model.BudgetCategory;
import com.Test.back.repository.BudgetCategoryRepository;
import com.Test.back.repository.BudgetRepository;
import com.Test.back.service.BudgetCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaBudgetCategoryService implements BudgetCategoryService {

    private BudgetCategoryRepository budgetCategoryRepository;

    @Override
    public Optional<BudgetCategory> findOne(Long id) {
        return budgetCategoryRepository.findById(id);
    }

    @Override
    public List<BudgetCategory> findAll() {
        return budgetCategoryRepository.findAll();
    }

    @Override
    public Page<BudgetCategory> findAll(Integer pageNo) {
        return budgetCategoryRepository.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public BudgetCategory save(BudgetCategory budgetCategory) {
        return budgetCategoryRepository.save(budgetCategory);
    }

    @Override
    public BudgetCategory update(BudgetCategory budgetCategory) {
        return budgetCategoryRepository.save(budgetCategory);
    }

    @Override
    public BudgetCategory delete(Long budgetId) {
        Optional<BudgetCategory> category = budgetCategoryRepository.findById(budgetId);
        if(category.isPresent()){
            budgetCategoryRepository.deleteById(budgetId);
            return category.get();
        }
        return null;
    }

    @Override
    public Page<BudgetCategory> find(Long budgetId, Integer pageNo) {
        return budgetCategoryRepository.findByBudgetCategoryId(budgetId, PageRequest.of(pageNo, 5));
    }
}
