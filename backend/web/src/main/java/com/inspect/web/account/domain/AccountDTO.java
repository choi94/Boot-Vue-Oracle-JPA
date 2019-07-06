package com.inspect.web.account.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class AccountDTO {
    private String accountEmail;
    private String accountPassword;
    private String accountName;
    private String accountReg;
}