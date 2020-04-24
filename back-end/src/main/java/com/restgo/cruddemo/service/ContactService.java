package com.restgo.cruddemo.service;

import com.restgo.cruddemo.dao.entity.Contact;
import com.restgo.cruddemo.dao.repository.ContactRepository;
import com.restgo.cruddemo.dto.ContactDto;
import com.restgo.cruddemo.exception.NotFoundException;
import com.restgo.cruddemo.mapper.ContactMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 3:27 PM
 */
@Service
public class ContactService {
    private final ContactRepository repository;
    private final ContactMapper mapper;

    public ContactService(ContactRepository repository, ContactMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ContactDto> getAll() {
        List<Contact> all = repository.findAll();
        return mapper.toDtos(all);
    }

    public ContactDto getOne(Long id) {
        Contact contact = repository.findById(id).orElseThrow(() -> {
            return new NotFoundException(String.valueOf(id));
        });
        return mapper.entityToDto(contact);
    }

    public ContactDto create(ContactDto contactDto) {
        Contact contact = mapper.dtoToEntity(contactDto);
        Contact save = repository.save(contact);
        return mapper.entityToDto(save);
    }

    public ContactDto update(Long id, ContactDto contactDto) {
        Contact contact = repository.findById(id).orElseThrow(() -> new NotFoundException(String.valueOf(id)));
        contact.setName(contactDto.getName());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        Contact save = repository.save(contact);
        return mapper.entityToDto(save);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }



}
