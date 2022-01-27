package com.myhome.controller;

import com.myhome.domain.Board;
import com.myhome.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
