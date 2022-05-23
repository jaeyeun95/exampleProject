package com.jy.sample.board.application;

import com.jy.sample.board.domain.Board;
import com.jy.sample.board.domain.BoardDTO;
import com.jy.sample.board.domain.BoardRepository;
import com.jy.sample.response.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardDTO createBoard(Map<String, String> request) {
        Board board = Board.builder()
                .content(request.get("content"))
                .build();

        boardRepository.save(board);

        BoardDTO boardDTO = BoardDTO.builder()
                .idx(board.getIdx())
                .content(board.getContent())
                .build();

        return boardDTO;
    }

    public List<Board> getBoardList() {

        List<Board> boardList = null;
        try {
            boardList = boardRepository.findAll();
            throw new NotFoundException("에러 발생시켰지롱");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return boardList;
    }
}
