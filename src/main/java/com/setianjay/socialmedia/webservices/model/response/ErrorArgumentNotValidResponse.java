package com.setianjay.socialmedia.webservices.model.response;

import org.springframework.http.HttpStatus;

import java.util.*;

public class ErrorArgumentNotValidResponse {
    private final Integer code;

    private final String status;

    private final Map<String, List<String>> errors;

    public ErrorArgumentNotValidResponse(HttpStatus httpStatus, Map<String, List<String>> errors) {
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.errors = errors;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, List<String>> getErrors(){
        return this.errors;
    }
}
