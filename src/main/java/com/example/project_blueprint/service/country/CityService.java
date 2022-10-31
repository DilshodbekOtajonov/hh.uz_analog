package com.example.project_blueprint.service.country;

import com.example.project_blueprint.domains.address.City;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:49 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface CityService {
    City getCityById(Long id);
}
