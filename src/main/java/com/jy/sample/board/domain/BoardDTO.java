package com.jy.sample.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

    private Integer idx;

    private String content;

    @Builder
    public BoardDTO(Integer idx, String content) {
        this.idx = idx;
        this.content = content;
    }

}
