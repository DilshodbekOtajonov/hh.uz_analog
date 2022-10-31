package com.example.project_blueprint.service.country;

import com.example.project_blueprint.domains.address.Country;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:51 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface CountryService {
    Country getCountryById(Long id);
}
