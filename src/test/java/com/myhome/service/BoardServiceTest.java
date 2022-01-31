package com.myhome.service;

import com.myhome.domain.Board;
import com.myhome.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void 글작성테스트() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        //when
        Long boardId = boardService.save(board);

        //then
        Board getBoard = boardRepository.findOne(boardId);

        Assertions.assertEquals(1, getBoard.getId());
    }

}
