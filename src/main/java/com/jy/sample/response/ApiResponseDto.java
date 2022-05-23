package com.jy.sample.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonDeserialize
public class ApiResponseDto<T> {

    private ApiResponseCode code;
    private String message;
    private int status;
    private T data;

    public ApiResponseDto(ApiResponseCode code, T data){
        bindStatus(code);
        this.data = data;
    }

    public ApiResponseDto(ApiResponseCode code, T data, String message) {
        bindStatus(code);
        this.data = data;
    }

    public ApiResponseDto(ApiResponseCode code) {
        bindStatus(code);
    }

    public ApiResponseDto(ApiResponseCode code, String message) {
        bindStatus(code);
        this.message = message;
    }

    public void bindStatus(ApiResponseCode status){
        this.code = status;
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    public static <T> ApiResponseDto<T> OK(T data) {
        return new ApiResponseDto<>(ApiResponseCode.OK, data);
    }

    public static <T> ApiResponseDto<T> setCode(ApiResponseCode apiResponseCode){
        return new ApiResponseDto<>(apiResponseCode);
    }
}
