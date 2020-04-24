package com.restgo.cruddemo.mapper;

import com.restgo.cruddemo.dao.entity.Contact;
import com.restgo.cruddemo.dto.ContactDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Author: Khumoyun Khujamov
 * Date: 4/21/2020
 * Time: 3:44 PM
 */
@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDto entityToDto(Contact contact);

    Contact dtoToEntity(ContactDto contactDto);

    List<ContactDto> toDtos(List<Contact> contacts);
}
