package com.inspect.web.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
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
            if (a.existsById(email)){
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

    public HashMap<String,Object> save(Account account) {
        Function<AccountRepository,HashMap<String,Object>> joinCheck = a -> {
            HashMap<String, Object> value = existsById(account.getAccountEmail());

            if (value.get("result").equals("false")) {
                a.save(account);
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

    public HashMap<String, Object> login(AccountDTO account) {
        System.out.println(account);
        BiFunction<AccountDTO,AccountRepository, HashMap<String,Object>> loginCheck = (a,s) -> {
            HashMap<String, Object> result = new HashMap<>();

            Optional<Account> check = s.findByAccountEmailAndAccountPassword(a.getAccountEmail(), a.getAccountPassword());
            if (check.isPresent()){
                result.put("result", "로그인 성공");
                result.put("email", a.getAccountEmail());
            } else {
                result.put("result", "로그인 실패");
            }
            return result;
        };
        return loginCheck.apply(account, accountRepository);
    }


}