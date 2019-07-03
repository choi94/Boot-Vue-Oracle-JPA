package com.inspect.web.account.repository;


import java.util.Optional;

import com.inspect.web.account.entity.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
    public Optional<Account> findByAccountEmailAndAccountPassword(String Email, String Password);
    
}