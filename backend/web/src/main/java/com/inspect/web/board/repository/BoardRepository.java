package com.inspect.web.board.repository;

import java.util.List;

import com.inspect.web.board.entity.Board;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>{

    @Query(value="SELECT RESULT.* FROM ( SELECT ROWNUM AS rnum, TEMP.* FROM (SELECT * FROM BOARD ORDER BY BOARD_NUM DESC) TEMP) RESULT WHERE 1 = 1 AND rnum BETWEEN ?1 AND ?2", nativeQuery=true)
    public List<Board> findByPageing(int startRow, int endRow );
}