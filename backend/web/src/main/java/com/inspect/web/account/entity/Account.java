package com.inspect.web.account.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ACCOUNT_EMAIL", nullable = false)
    private String accountEmail;

    @Column(name = "ACCOUNT_PASSWORD", nullable = false)
    private String accountPassword;

    @Column(name = "ACCOUNT_NAME", nullable = false)
    private String accountName;

    @UpdateTimestamp
    @Column(name = "ACCOUNT_REG", nullable = false)
    private Timestamp accountReg;
    
}