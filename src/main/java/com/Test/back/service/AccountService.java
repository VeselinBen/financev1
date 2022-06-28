package com.Test.back.service;

import com.Test.back.model.Account;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findOne(Long id);

    List<Account> findAll();

    Page<Account> findAll(Integer pageNo);

    Account save(Account account);

    Account update(Account account);

    Account delete(Long accountId);

    Page<Account> find(String accountName, Integer pageNo);
}
