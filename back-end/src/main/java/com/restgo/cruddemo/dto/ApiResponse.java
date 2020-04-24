package com.restgo.cruddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 5:22 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;
}
