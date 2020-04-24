package com.restgo.cruddemo.exception;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 5:18 PM
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(String.format("Resource with id %s not found",message));
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
