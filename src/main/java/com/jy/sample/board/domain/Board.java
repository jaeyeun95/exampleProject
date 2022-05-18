package com.jy.sample.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name = "content")
    private String content;

    @Builder
    public Board(String content) {
        this.content = content;
    }
}
