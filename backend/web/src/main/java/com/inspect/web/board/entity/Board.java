package com.inspect.web.board.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.inspect.web.account.entity.Account;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Component
@NoArgsConstructor
@Entity
@ToString(exclude = "account")
@Getter
@Table(name = "Board")
@EqualsAndHashCode(of = "boardEmail")
public class Board implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BOARD_NUM")
    private Long boardNum;

    @Column(name = "BOARD_EMAIL")
    private String boardEmail;

    @Column(name = "BOARD_TITLE", nullable = false)
    private String boardTitle;

    @Column(name = "BOARD_CONTENTS", nullable = false)
    private String boardContents;

    @Column(name = "BOARD_VIEWS", columnDefinition = "number(5) default 0", insertable = false)
    private Integer boardViews;

    @CreationTimestamp
    @Column(name = "BOARD_REG")
    private Timestamp boardReg;

    @ManyToOne
    private Account account;
    
}