package com.Test.back.service;

import com.Test.back.model.Transaction;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> findOne(Long id);

    List<Transaction> findAll();

    Page<Transaction> findAll(Integer pageNo);

    Transaction save(Transaction transaction);

    Transaction update(Transaction transaction);

    Transaction delete(Long transactionId);

    Page<Transaction> find(Long transactionId, Long categoryId, Long accountId, Integer pageNo);
}
