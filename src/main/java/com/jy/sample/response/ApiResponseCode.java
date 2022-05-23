package com.jy.sample.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiResponseCode {

    OK(200, "요청이 성공하였습니다."),
    EXTERNAL_API(423, "External 에러"),
    SERVER_ERROR(500, "Internal Server Error. 서버 에러 입니다."),
    NOT_FOUND(404, "Not Found. 리소스를 차지 못하였습니다."),
    BAD_PARAMETER(402, "필수 파라미터가 존재하지 않습니다."),
    BAD_REQUEST(400, "Bad Request. 잘못된 요청입니다.");

    private final int code;
    private final String message;

}
