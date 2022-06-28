package com.Test.back.service.impl;

import com.Test.back.model.Account;
import com.Test.back.repository.AccountRepository;
import com.Test.back.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaAccountService implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public Optional<Account> findOne(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> findAll(Integer pageNo) {
        return accountRepository.findAll(PageRequest.of(pageNo,5));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if(account.isPresent()){
            accountRepository.deleteById(accountId);
            return account.get();
        }
        return null;
    }

    @Override
    public Page<Account> find(String accountName, Integer pageNo) {
        if(accountName == null){
            accountName = "";
        }
        return accountRepository.findByAccountNameContaining(accountName, PageRequest.of(pageNo,5));
    }
}
