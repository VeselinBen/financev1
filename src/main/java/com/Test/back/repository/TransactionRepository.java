package com.Test.back.repository;

import com.Test.back.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    Page<Transaction> findByTransactionIdAndCategoryIdAndAaccountId(Long transactionId, Long categoryId, Long accountId, Pageable pageable);
}
