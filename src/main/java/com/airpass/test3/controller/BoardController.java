package com.airpass.test3.controller;

import com.airpass.test3.entity.Board;
import com.airpass.test3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

//    @GetMapping("/")
//    @ResponseBody
//    public String main() {
//        return "hello word";
//    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm() {
        return "boardWrite";
    }

    @GetMapping("/board/writedo")
    public void boardWriteDo(Board board) {
        boardService.write(board);
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());
        // 반환된 보더리스트를 list 라는 이름으로 보냄

        return "boardList";
    }

    @GetMapping("/board/boardView")
    public String boardView(Model model, Integer id) {

        model.addAttribute("view", boardService.boardView(id));

        return "boardView";
    }

    @GetMapping("/board/boardDel")
    public String boardDel(Integer id) {
        boardService.boardDel(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/boardModify/{id}")
    public String boardModify(Model model,@PathVariable("id") Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardModify";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        System.out.println(board.getTitle());
        System.out.println(board.getContent());

        Board boardTemp = boardService.boardView(id); //기존 거 가져옴
        boardTemp.setTitle(board.getTitle()); // 덮어씌움
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);
        // JPA에는 변경 감지(Dirty Checking)이라는 기능
        // JPA 변경감지, JPA merge, JPA persist 등 꼭 따로 학습

        return "redirect:/board/list";
    }

}
