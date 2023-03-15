package com.setianjay.socialmedia.webservices.exception.handler;

import com.setianjay.socialmedia.webservices.constant.Constant;
import com.setianjay.socialmedia.webservices.exception.ResourceNotFoundException;
import com.setianjay.socialmedia.webservices.exception.model.ErrorServerResponse;
import com.setianjay.socialmedia.webservices.exception.model.ErrorResourceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorResponseEntityHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorServerResponse> handleException(Exception e){
        ErrorServerResponse errorServerResponse = new ErrorServerResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Constant.ErrorMessage.INTERNAL_SERVER_ERROR
        );

        return new ResponseEntity<>(errorServerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResourceResponse> handleException(ResourceNotFoundException e){
        ErrorResourceResponse errorResourceResponse = new ErrorResourceResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return new ResponseEntity<>(errorResourceResponse, HttpStatus.NOT_FOUND);
    }
}
