package com.Test.back.repository;

import com.Test.back.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findByCategoryIdAndCategoryNameContaining(Long categoryId, String categoryName, Pageable pageable);
}
