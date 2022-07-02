package com.jy.sample.board;

import com.jy.sample.board.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class BoardTest {

    @Test
    void 게시글작성() {
        String content = "게시글 테스트";

        Board board = Board.builder().content(content).build();

        Assertions.assertThat(board.getContent()).isEqualTo("게시글 테스트");
    }
}
