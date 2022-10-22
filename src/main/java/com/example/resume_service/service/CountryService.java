package com.example.resume_service.service;

import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.dto.CountryCreateDTO;
import com.example.resume_service.exceptions.GenericNotFoundException;
import com.example.resume_service.repository.CountryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 1:26 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository rep;

    public CountryEntity checkCountryName(String countryName) {
      return   rep.checkCountryName(countryName).
                orElseThrow(()->
                        new GenericNotFoundException ("Country  not found by name: %s".formatted ( countryName )));
    }

    public CountryEntity save(CountryCreateDTO dto) {
        return rep.save ( CountryEntity.builder ().countryName ( dto.getCountryName () ).build () );
    }

    public List<CountryEntity> getAll() {
        return rep.findAll ();
    }
}
