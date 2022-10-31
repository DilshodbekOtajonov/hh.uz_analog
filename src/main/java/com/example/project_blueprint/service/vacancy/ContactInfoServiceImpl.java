package com.example.project_blueprint.service.vacancy;

import com.example.project_blueprint.domains.vacancy.ContactInfo;
import com.example.project_blueprint.exceptions.ContactInfoNotFoundException;
import com.example.project_blueprint.repository.vacancy.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:56 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    @Override
    public ContactInfo getContactInfoById(Long id) {
        ContactInfo contactInfoNotFoundById = contactInfoRepository.findById(id).orElseThrow(() -> {
            throw new ContactInfoNotFoundException("ContactInfo Not Found By Id");
        });
        return contactInfoNotFoundById;
    }

}
