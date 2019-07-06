package com.inspect.web.account.controller;

import java.util.HashMap;

import com.inspect.web.account.domain.AccountDTO;
import com.inspect.web.account.entity.Account;
import com.inspect.web.account.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired AccountService accountService;

    @PostMapping(value = "/join")
    public HashMap<String,Object> join(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PostMapping(value = "/login")
    public HashMap<String, Object> login(@RequestBody AccountDTO account) {
        System.out.println(account.toString());
        return accountService.login(account);
    }

}