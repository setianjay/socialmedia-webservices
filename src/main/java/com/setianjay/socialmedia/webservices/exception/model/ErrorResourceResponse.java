package com.setianjay.socialmedia.webservices.exception.model;

public class ErrorResourceResponse {
    private final Boolean success;
    private final int code;
    private final String message;

    public ErrorResourceResponse(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
