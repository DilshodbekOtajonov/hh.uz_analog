package com.example.project_blueprint.service.country;

import com.example.project_blueprint.domains.address.City;
import com.example.project_blueprint.exceptions.CityNotFoundException;
import com.example.project_blueprint.repository.address.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:50 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService{
      private final CityRepository cityRepository;

    @Override
    public City getCityById(Long id) {
        City cityNotFoundById = cityRepository.findById(id).orElseThrow(() -> {
            throw new CityNotFoundException("City Not Found By Id");
        });
        return cityNotFoundById;
    }
}
