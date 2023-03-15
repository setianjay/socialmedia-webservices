package com.setianjay.socialmedia.webservices.advice;

import com.setianjay.socialmedia.webservices.constant.Constant;
import com.setianjay.socialmedia.webservices.exception.ResourceNotFoundException;
import com.setianjay.socialmedia.webservices.model.response.ErrorResourceResponse;
import com.setianjay.socialmedia.webservices.model.response.ErrorServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionResponseHandler {

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
