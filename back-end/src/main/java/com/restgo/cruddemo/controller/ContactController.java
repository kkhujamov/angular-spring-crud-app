package com.restgo.cruddemo.controller;

import com.restgo.cruddemo.dto.ApiResponse;
import com.restgo.cruddemo.dto.ContactDto;
import com.restgo.cruddemo.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 5:59 PM
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/contacts")
public class ContactController {
    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponse(true, "", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse(true, "", service.getOne(id)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContactDto contactDto) {
        return ResponseEntity.ok(new ApiResponse(true, "", service.create(contactDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody ContactDto contactDto) {
        return ResponseEntity.ok(new ApiResponse(true, "", service.update(id,contactDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
