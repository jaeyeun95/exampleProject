package com.jy.sample.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDto<T> {

    private String message;

    private List<T> data;

    @Builder
    public ResponseDto(String message, List<T> data) {
        this.message = message;
        this.data = data;
    }
}
