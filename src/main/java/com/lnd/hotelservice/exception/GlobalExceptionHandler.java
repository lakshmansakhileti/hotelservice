package com.lnd.hotelservice.exception;

import com.lnd.hotelservice.response.ApiResponse;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiResponse> handleBadException(HttpClientErrorException httpClientErrorException) {
        ApiResponse response = new ApiResponse(httpClientErrorException.getLocalizedMessage(),
                Boolean.FALSE, httpClientErrorException.getStatusCode());
       return ResponseEntity.status(httpClientErrorException.getStatusCode()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception exception) {
        ApiResponse response = new ApiResponse(exception.getLocalizedMessage(),
                Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
