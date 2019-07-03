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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired BoardService boardService;
    
    @GetMapping(value = "/list")
    public List<BoardDTO> list() {
        return boardService.findAll();
    }

    @PostMapping(value="/write")
    public HashMap<String, Object> write(@RequestBody Board board) {
        System.out.println("들어옴!");
        System.out.println(board.toString());
        return boardService.save(board);
    }

}   