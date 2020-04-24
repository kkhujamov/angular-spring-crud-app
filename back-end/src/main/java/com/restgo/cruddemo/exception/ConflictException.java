package com.restgo.cruddemo.exception;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 5:35 PM
 */
public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }
}
