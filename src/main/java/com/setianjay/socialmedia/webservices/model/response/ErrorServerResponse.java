package com.setianjay.socialmedia.webservices.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorServerResponse {
    private final String status;
    @JsonProperty("status_code")
    private final Integer statusCode;
    @JsonProperty("status_message")
    private final String statusMessage;

    public ErrorServerResponse(Integer statusCode, String statusMessage) {
        this.status = "error";
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
