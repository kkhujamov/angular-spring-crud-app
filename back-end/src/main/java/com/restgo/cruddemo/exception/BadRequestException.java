package com.restgo.cruddemo.exception;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 5:37 PM
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
