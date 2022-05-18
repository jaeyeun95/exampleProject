package com.jy.sample.board.ui;

import com.jy.sample.board.application.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity saveJson(@RequestBody Map<String, String> request){

        log.info("게시글 등록 request : {}", request);

        boardService.createBoard(request);
        return ResponseEntity.ok(null);
    }
}
