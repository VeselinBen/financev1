package com.Test.back.service.impl;

import com.Test.back.model.Category;
import com.Test.back.repository.CategoryRepository;
import com.Test.back.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findOne(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Integer pageNo) {
        return categoryRepository.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            categoryRepository.deleteById(categoryId);
            return category.get();
        }
        return null;
    }

    @Override
    public Page<Category> find(Long categoryId, String categoryName, Integer pageNo) {
        return categoryRepository.findByCategoryIdAndCategoryNameContaining(categoryId, categoryName, PageRequest.of(pageNo, 5));
    }
}
