package com.inspect.web.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.inspect.web.board.domain.BoardDTO;
import com.inspect.web.board.entity.Board;
import com.inspect.web.board.repository.BoardRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired BoardRepository boardRepository;
    @Autowired BoardDTO boardDTO;
    @Autowired Board boardEntity;
    @Autowired ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public long count() {
        return boardRepository.count();
    }

    public void deleteById(Long boardNum) {
        boardRepository.deleteById(boardNum);
    }

    public HashMap<String, Object> existsById(Long boardNum) {
        Function<BoardRepository, HashMap<String,Object>> boardCheck = a -> {
            HashMap<String, Object> result = new HashMap<>();
            if (boardRepository.existsById(boardNum)){
                result.put("result", "존재함");
            } else {
                result.put("result", "존재함");
            }
            return result;
        };
        
        return boardCheck.apply(boardRepository);
    }

    public List<BoardDTO> findAll() {
        Function<BoardRepository, List<BoardDTO>> boardList = b -> {
            List<BoardDTO> boardDTO = new ArrayList<>();
            Iterable<Board> boards = boardRepository.findAll();

            for (Board p : boards){
                boardDTO.add(modelMapper.map(p, BoardDTO.class)); 
            }

            return boardDTO;
        };

        return boardList.apply(boardRepository);
    }

    public BoardDTO findById(Long boardNum) {
        Function<BoardRepository, BoardDTO> boardList = b -> {
            Optional<Board> result = b.findById(boardNum);

            if(result.isPresent()){
                boardDTO = modelMapper.map(result.get(), BoardDTO.class);
            }

            return boardDTO;
        };

        return boardList.apply(boardRepository);
    }

    public HashMap<String, Object> save(BoardDTO board){
        Function<BoardDTO, HashMap<String,Object>> boardSave = b -> {
            HashMap<String, Object> result = new HashMap<>();

            boardEntity = modelMapper.map(board, Board.class);
            boardRepository.save(boardEntity);
            result.put("result", "글쓰기 완료");
            return result;
        };
        return boardSave.apply(board);
    }
}