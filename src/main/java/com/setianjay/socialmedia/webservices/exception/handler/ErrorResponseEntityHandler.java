package com.setianjay.socialmedia.webservices.exception.handler;

import com.setianjay.socialmedia.webservices.constant.Constant;
import com.setianjay.socialmedia.webservices.exception.UserNotFoundException;
import com.setianjay.socialmedia.webservices.exception.model.ErrorServerResponse;
import com.setianjay.socialmedia.webservices.exception.model.ErrorUserResponse;
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

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorUserResponse> handleException(UserNotFoundException e){
        ErrorUserResponse errorUserResponse = new ErrorUserResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return new ResponseEntity<>(errorUserResponse, HttpStatus.NOT_FOUND);
    }
}
