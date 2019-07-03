package com.inspect.web.board.repository;

import java.util.List;

import com.inspect.web.board.domain.BoardDTO;
import com.inspect.web.board.entity.Board;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>{

    @Query("SELECT b FROM Board b ORDER BY b.boardNum DESC")
    public List<BoardDTO> findByPageing(Pageable pageing);
}