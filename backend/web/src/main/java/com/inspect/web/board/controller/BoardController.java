package com.inspect.web.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import com.inspect.web.board.domain.BoardDTO;
import com.inspect.web.board.entity.Board;
import com.inspect.web.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// @CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired BoardService boardService;
    
    @GetMapping(value = "/list/{pageNum}")
    public HashMap<String,Object> list(@PathVariable("pageNum")String pageNum) {
        return boardService.findbyPageing(pageNum);
    }

    @PostMapping(value="/write")
    public HashMap<String, Object> write(@RequestBody Board board) {
        return boardService.save(board);
    }

    @GetMapping(value = "/view/{boardNum}")
    public BoardDTO view(@PathVariable("boardNum")Long boardNum) {
        return boardService.findById(boardNum);
    }

    @DeleteMapping(value = "/view/{boardNum}")
    public void delete(@PathVariable("boardNum")Long boardNum) {
        boardService.deleteById(boardNum);
    }

    @PutMapping(value = "/view")
    public void update(@RequestBody BoardDTO board) {
        System.out.println(board.toString());
        boardService.modify(board);
    }

}   