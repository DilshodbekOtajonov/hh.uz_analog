package com.example.project_blueprint.service.vacancy;

import com.example.project_blueprint.domains.vacancy.ContactInfo;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:56 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface ContactInfoService {

    ContactInfo getContactInfoById(Long id);
}
