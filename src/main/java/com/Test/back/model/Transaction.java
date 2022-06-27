package com.Test.back.model;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String notes;

    @Column(nullable = true)
    private double amountIn;

    @Column(nullable = true)
    private double amountOut;

    @Column
    private boolean cleared;

    @ManyToOne
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;
}