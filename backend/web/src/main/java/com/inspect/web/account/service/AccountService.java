package com.inspect.web.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import com.inspect.web.account.domain.AccountDTO;
import com.inspect.web.account.entity.Account;
import com.inspect.web.account.repository.AccountRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired Account accountEntity;
    @Autowired AccountDTO accountDTO;
    @Autowired ModelMapper modelMapper;
    @Autowired AccountRepository accountRepository;
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public long count() {
        return accountRepository.count();
    }

    public void deleteById(String email) {
        accountRepository.deleteById(email);
    }

    public HashMap<String, Object> existsById(String email) {
        Function<AccountRepository, HashMap<String,Object>> emailCheck = a -> {
            HashMap<String, Object> result = new HashMap<String, Object>();
            if (accountRepository.existsById(email)){
                result.put("result", "true");
            } else {
                result.put("result", "false");
            }
            return result;
        };
        return emailCheck.apply(accountRepository);
    }

    public List<AccountDTO> findAll() {
        return null;
    }

    public AccountDTO findById() {
        return null;
    }

    public HashMap<String,Object> save(AccountDTO account){
        Function<AccountRepository,HashMap<String,Object>> joinCheck = a -> {
            HashMap<String, Object> value = existsById(account.getAccountEmail());
            
            if (value.get("result").equals("true")) {
                accountEntity = modelMapper.map(account, Account.class);
                value.clear();
                value.put("result", "회원가입 성공");
            } else {
                value.clear();
                value.put("result", "이미 존재하는 아이디");
            }
            return value;
        };
        return joinCheck.apply(accountRepository);
    }

}