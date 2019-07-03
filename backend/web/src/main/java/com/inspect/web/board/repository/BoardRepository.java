package com.inspect.web.board.repository;

import com.inspect.web.board.entity.Board;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>{

    
}