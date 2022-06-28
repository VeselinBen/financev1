package com.Test.back.service;

import com.Test.back.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findOne(Long id);

    List<Category> findAll();

    Page<Category> findAll(Integer pageNo);

    Category save(Category category);

    Category update(Category category);

    Category delete(Long categoryId);

    Page<Category> find(Long categoryId, String categoryName, Integer pageNo);
}
