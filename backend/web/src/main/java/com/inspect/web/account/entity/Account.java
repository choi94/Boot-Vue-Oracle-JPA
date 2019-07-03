package com.inspect.web.account.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ACCOUNT_EMAIL")
    private String accountEmail;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @UpdateTimestamp
    @Column(name = "ACCOUNT_REG")
    private Timestamp accountReg;
    
}