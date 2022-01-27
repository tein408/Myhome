package com.myhome.controller;

import com.myhome.domain.Board;
import com.myhome.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    @GetMapping (value = "/generic")
    public String generic(Model model) {
        List<Board> boardList = boardService.findBoards();
        model.addAttribute("boardList", boardList);
        return "generic";
    }

    @GetMapping(value = "/generic/{id}")
    public String board(@PathVariable ("id") Long id, Model model) {
        Board board = boardService.findOne(id);
        model.addAttribute("board", board);
        return "generic/board";
    }

    @GetMapping(value = "/generic/write")
    public String createForm(Model model) {
        model.addAttribute("form", new BoardForm());
        return "generic/writeForm";
    }

    @PostMapping(value = "/generic/write")
    public String create(BoardForm boardForm) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());

        Long id = boardService.save(board);
        return "redirect:/generic/" + id;
    }

}
