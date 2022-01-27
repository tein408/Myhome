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

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

}
