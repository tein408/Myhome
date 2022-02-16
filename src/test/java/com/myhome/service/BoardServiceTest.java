package com.myhome.service;

import com.myhome.domain.Board;
import com.myhome.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

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
        Assertions.assertEquals(board.getId(), boardRepository.findOne(boardId).getId());
    }

    @Test
    public void 글수정테스트() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        //when
        Long boardId = boardService.save(board);
        boardService.updateBoard(boardId, "제목수정", "내용수정");

        //then
        Board getBoard = boardRepository.findOne(boardId);

        Assertions.assertEquals("제목수정", getBoard.getTitle());
    }

    @Test
    public void 글_전체조회_테스트() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        Board board2 = new Board();
        board2.setTitle("title2");
        board2.setContent("content2");

        //when
        boardService.save(board);
        boardService.save(board2);

        //then
        List<Board> boardList = boardService.findBoards();

        Assertions.assertEquals(2, boardList.size());
    }

    @Test
    public void 글_삭제_테스트() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        Board board2 = new Board();
        board2.setTitle("title2");
        board2.setContent("content2");

        //when
        Long boardId = boardService.save(board);
        boardService.save(board2);

        //then
        boardService.deleteById(boardId);
        List<Board> boardList = boardService.findBoards();

        Assertions.assertEquals(1, boardList.size());
    }

    @Test
    public void 조회수() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        //when
        Long boardId = boardService.save(board);
        Board findBoard = boardService.addCount(boardId);

        //then
        Assertions.assertEquals(1, findBoard.getCount());
    }

    @Test
    public void findOne() throws Exception {
        //given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("content");

        Board board2 = new Board();
        board2.setTitle("title2");
        board2.setContent("content2");

        //when
        Long boardOne = boardService.save(board);
        boardService.save(board2);

        //then
        Assertions.assertEquals(board, boardRepository.findOne(boardOne));
    }

}
