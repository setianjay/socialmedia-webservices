package com.setianjay.socialmedia.webservices.advice;

import com.setianjay.socialmedia.webservices.constant.Constant;
import com.setianjay.socialmedia.webservices.exception.ResourceNotFoundException;
import com.setianjay.socialmedia.webservices.model.response.ErrorArgumentNotValidResponse;
import com.setianjay.socialmedia.webservices.model.response.ErrorResourceNotFoundResponse;
import com.setianjay.socialmedia.webservices.model.response.ErrorServerResponse;
import com.setianjay.socialmedia.webservices.util.ExceptionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionResponseHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorServerResponse> handleException(Exception e) {
        ErrorServerResponse errorServerResponse = new ErrorServerResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Constant.ErrorMessage.INTERNAL_SERVER_ERROR
        );

        return new ResponseEntity<>(errorServerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorArgumentNotValidResponse> handleException(MethodArgumentNotValidException e) {
        ErrorArgumentNotValidResponse response = new ErrorArgumentNotValidResponse(
                HttpStatus.BAD_REQUEST,
                ExceptionUtil.getFieldsWithError(e.getFieldErrors())
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResourceNotFoundResponse> handleException(ResourceNotFoundException e) {
        ErrorResourceNotFoundResponse errorResourceNotFoundResponse = new ErrorResourceNotFoundResponse(HttpStatus.NOT_FOUND, e.getMessage());

        return new ResponseEntity<>(errorResourceNotFoundResponse, HttpStatus.NOT_FOUND);
    }
}
