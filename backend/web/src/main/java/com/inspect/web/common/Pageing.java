package com.inspect.web.common;

import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Lazy
public class Pageing {
    private int pageNum, pageSize, blockSize, startRow, currentBlock, currentEndBlock,
            endRow, startPage, endPage, prevBlock, nextBlock, totalCount;

    private boolean existPrev, existNext;

    public void execute (Map<?,?> params) {

        totalCount = (int) params.get("totalCount");

        String _pageNum = (String)params.get("pageNum");
        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);

        String _pageSize = (String)params.get("pageSize");
        pageSize = (_pageSize == null) ? 7 : Integer.parseInt(_pageSize);

        String _blockSize = (String)params.get("blockSize");
        blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);

        int pageCount = ((totalCount % pageSize) == 0) ? totalCount / pageSize : totalCount / pageSize + 1;

        startRow = (pageNum -1) * pageSize;
        endRow = (totalCount > pageNum * pageSize) ? pageNum * pageSize : totalCount;
        
        currentBlock = (pageNum % pageSize) > 0 ? pageNum / pageSize +1 : pageNum / pageSize;
        startPage = (currentBlock * pageSize) - (pageSize -1); // 현재 블록의 시작페이지를 구함

        currentEndBlock = (pageCount % pageSize) > 0 ? pageCount / pageSize +1 : pageCount / pageSize;
        endPage = currentBlock == currentEndBlock ? pageCount : startPage + (pageSize -1); // 현재 블록의 끝페이지를 구함

        existPrev = currentBlock-1 > 0;
        existNext = currentBlock < currentEndBlock;

        prevBlock = startPage - pageSize;
        nextBlock = startPage + pageSize;
    }
}