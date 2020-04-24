package com.restgo.cruddemo.dao.repository;

import com.restgo.cruddemo.dao.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 3:26 PM
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
