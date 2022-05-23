package com.jy.sample.response.exception;

import com.jy.sample.response.ApiResponseCode;

public class NotFoundException extends RuntimeException{

    private ApiResponseCode apiResponseCode;

    public NotFoundException(ApiResponseCode apiResponseCode){
        this.apiResponseCode = apiResponseCode;
    }

    public NotFoundException(String message) {
        super(message);
    }

    ApiResponseCode getApiResponseCode() {
        return apiResponseCode;
    }
}
