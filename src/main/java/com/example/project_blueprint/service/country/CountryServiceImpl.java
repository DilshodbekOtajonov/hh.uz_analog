package com.example.project_blueprint.service.country;

import com.example.project_blueprint.domains.address.Country;
import com.example.project_blueprint.exceptions.CountryNotFoundException;
import com.example.project_blueprint.repository.address.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:51 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    @Override
    public Country getCountryById(Long id) {
        Country countyNotFoundById = countryRepository.findById(id).orElseThrow(() -> {
            throw new CountryNotFoundException("County Not Found By Id");
        });
        return countyNotFoundById;
    }
}
