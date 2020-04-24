package com.restgo.cruddemo.controller;

import com.restgo.cruddemo.dto.ApiResponse;
import com.restgo.cruddemo.exception.BadRequestException;
import com.restgo.cruddemo.exception.ConflictException;
import com.restgo.cruddemo.exception.NotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 6:34 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { BadRequestException.class,
            NoSuchFieldException.class,
            NumberFormatException.class,
            IllegalArgumentException.class})
    public HttpEntity<?> runtime(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, e.getMessage(), null));
    }

    @ExceptionHandler(NotFoundException.class)
    public HttpEntity<?> notFoundHandler(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage(),null));
    }

    @ExceptionHandler(ConflictException.class)
    public HttpEntity<?> conflictHandler(ConflictException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, e.getMessage(), null));
    }

}
