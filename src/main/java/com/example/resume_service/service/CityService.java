package com.example.resume_service.service;

import com.example.resume_service.domains.CityEntity;
import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.dto.country.CityCreateDto;
import com.example.resume_service.exceptions.GenericNotFoundException;
import com.example.resume_service.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 5:03 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;
    private final CountryService service;

    public String checkCity(String city) {
        CityEntity city1 = repository.checkCity ( city ).orElseThrow ( () ->
                new GenericNotFoundException ( "City  not found by name: %s".formatted ( city ), 404 ) );
   return city1.getCityName ();
    }



    public CityEntity save(CityCreateDto cityCreateDto) {
        CountryEntity countryEntity = service.checkCountryName ( cityCreateDto.getCountryName () );
        CityEntity city=CityEntity.builder ()
                .cityName ( cityCreateDto.getCityName () )
                .countryEntity ( countryEntity )
                .build ();
       return repository.save ( city );

    }

    public List<CityEntity> getAll() {
        return repository.findAll ();
    }
}
