package com.inspect.web.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.inspect.web.board.domain.BoardDTO;
import com.inspect.web.board.entity.Board;
import com.inspect.web.board.repository.BoardRepository;
import com.inspect.web.common.Pageing;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired BoardRepository boardRepository;
    @Autowired BoardDTO boardDTO;
    @Autowired Board boardEntity;
    @Autowired ModelMapper modelMapper;
    @Autowired Pageing pageing;

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
            Iterable<Board> boards = b.findAll();

            for (Board p : boards){
                boardDTO.add(modelMapper.map(p, BoardDTO.class)); 
            }

            return boardDTO;
        };

        return boardList.apply(boardRepository);
    }

    public HashMap<String,Object> findbyPageing(String pageNum) {

        BiFunction<String ,BoardRepository, HashMap<String,Object>> pageingSet = (s,b) -> {
            HashMap<String,Object> pageMap = new HashMap<>();
            int pageNumber = (int) b.count();
            pageMap.put("totalCount", pageNumber);
            pageMap.put("pageNum", s);
            return pageMap;
        };

        Function<BoardRepository, List<Board>> boardPageing = b -> {
            pageing.execute(pageingSet.apply(pageNum, b));
            int startRow = pageing.getStartRow() + 1;
            int endRow = pageing.getEndRow();

            return b.findByPageing(startRow, endRow);
        };

        List<Board> value = boardPageing.apply(boardRepository);
        List<BoardDTO> dtoValue = new ArrayList<>();

        for (Board b : value){
            dtoValue.add(modelMapper.map(b, BoardDTO.class));
        }

        HashMap<String,Object> result = new HashMap<>();
        result.put("list", dtoValue);
        result.put("pageing", pageing);

        return result;
    }

    public BoardDTO findById(Long boardNum) {
        Function<BoardRepository, BoardDTO> boardList = b -> {
            Optional<Board> result = b.findById(boardNum);

            result.get().setBoardViews(result.get().getBoardViews() + 1);

            boardEntity = result.get();
            boardRepository.save(boardEntity);

            if(result.isPresent()){
                boardDTO = modelMapper.map(result.get(), BoardDTO.class);
            }

            return boardDTO;
        };

        return boardList.apply(boardRepository);
    }

    public HashMap<String, Object> save(Board board) {
        Function<Board, HashMap<String,Object>> boardSave = b -> {
            HashMap<String, Object> result = new HashMap<>();

            boardEntity = modelMapper.map(board, Board.class);
            boardRepository.save(boardEntity);
            result.put("result", "글쓰기 완료");
            return result;
        };
        return boardSave.apply(board);
    }

    public void modify(BoardDTO board) {
        boardEntity = modelMapper.map(board, Board.class);
        boardRepository.save(boardEntity);
    }
}