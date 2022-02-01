package com.myhome.service;

import com.myhome.domain.Board;
import com.myhome.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

    @Transactional
    public Board updateBoard(Long id, String title, String content) {
        Board board = boardRepository.findOne(id);
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        return board;
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board addCount(Long id) {
        Board board = boardRepository.findOne(id);
        board.setCount(board.getCount() + 1);
        return board;
    }

}
