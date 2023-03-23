package com.setianjay.socialmedia.webservices.model.response;

import org.springframework.http.HttpStatus;

public class ErrorResourceNotFoundResponse {
    private final Integer code;
    private final String status;
    private final String message;

    public ErrorResourceNotFoundResponse(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
