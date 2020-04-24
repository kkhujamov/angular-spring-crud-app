package com.restgo.cruddemo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 3:38 PM
 */
@Data
public class ContactDto {
    private Long id;

    @NotEmpty
    private String name;

    @Min(5)
    @Max(15)
    private String phoneNumber;
}
