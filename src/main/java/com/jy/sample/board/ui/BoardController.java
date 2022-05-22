package com.jy.sample.board.ui;

import com.jy.sample.board.application.BoardService;
import com.jy.sample.board.domain.BoardDTO;
import com.jy.sample.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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


        BoardDTO boardDTO = boardService.createBoard(request);

//        ResponseDto responseDto = ResponseDto.builder()
//                .data((List<Object>) boardDTO)
//                .message("등록 성공")
//                .build();
        return ResponseEntity.ok(boardDTO);
    }

}
