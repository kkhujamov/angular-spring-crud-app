package com.restgo.cruddemo.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 3:17 PM
 */
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "phone_number"})
})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column( name = "phone_number", nullable = false)
    private String phoneNumber;
}
