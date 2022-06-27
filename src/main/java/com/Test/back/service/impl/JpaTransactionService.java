package com.Test.back.service.impl;

import com.Test.back.model.Transaction;
import com.Test.back.repository.TransactionRepository;
import com.Test.back.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaTransactionService implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public Optional<Transaction> findOne(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Page<Transaction> findAll(Integer pageNo) {
        return transactionRepository.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction delete(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if (transaction.isPresent()){
            transactionRepository.deleteById(transactionId);
            return  transaction.get();
        }
        return null;
    }

    @Override
    public Page<Transaction> find(Long transactionId, Long categoryId, Long accountId, Integer pageNo) {
//        return transactionRepository.findByTransactionIdAndCategoryIdAndAaccountId(transactionId, categoryId, accountId,PageRequest.of(pageNo, 5));
        return null;
    }
}
