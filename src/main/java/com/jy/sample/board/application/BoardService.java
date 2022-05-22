package com.jy.sample.board.application;

import com.jy.sample.board.domain.Board;
import com.jy.sample.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(Map<String, String> request) {
        Board board = Board.builder()
                .content(request.get("content"))
                .build();

        boardRepository.save(board);

    }
}
