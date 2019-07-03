package com.inspect.web.board.domain;

import java.sql.Timestamp;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class BoardDTO {
    private Long boardNum;
    private String boardEmail, boardTitle, boardContents;
    private Integer boardViews;
    private Timestamp boardReg;
}