package com.Test.back.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "budget_category")
public class BudgetCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetCategoryId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "category_budget_category",
            joinColumns = { @JoinColumn(name = "budget_category_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private Set<Category> categorySet = new HashSet<>();
}