package com.example.resume_service.service;

import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.dto.country.CountryCreateDTO;
import com.example.resume_service.exceptions.GenericNotFoundException;
import com.example.resume_service.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 1:26 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository rep;


    public CountryEntity save(CountryCreateDTO dto) {
        return rep.save ( CountryEntity.builder ().countryName ( dto.getCountryName () ).build () );
    }

    public List<CountryEntity> getAll() {
        return rep.findAll ();
    }


    public CountryEntity checkCountryName(String countryName) {
        return rep.checkCountryName ( countryName ).
                orElseThrow ( () ->
                        new GenericNotFoundException ( "Country  not found by name: %s".formatted ( countryName ),400 ) );
    }


    public List<CountryEntity> checkCityList(List<String> citizenship) {
        List<CountryEntity> countryEntityList = new ArrayList<> ();
        for (String s : citizenship) {
            if (Objects.nonNull ( s )) {
                countryEntityList.add ( rep.checkCountryName ( s ).orElseThrow ( () ->
                        new GenericNotFoundException ( "Country  not found by name: %s".formatted ( s ),400 ) )
                );
            }
        }
        return countryEntityList;
    }
}
