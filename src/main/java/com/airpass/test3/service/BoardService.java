package com.airpass.test3.service;

import com.airpass.test3.entity.Board;
import com.airpass.test3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    public void boardDel(Integer id) {
        boardRepository.deleteById(id);
    }

}
