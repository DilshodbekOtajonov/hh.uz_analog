package com.example.resume_service.service;

import com.example.resume_service.domains.CityEntity;
import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.dto.CityCreateDto;
import com.example.resume_service.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    public CityEntity checkCity(String city) {
        return repository.checkCity(city);
    }

    public List<CityEntity> checkCity(Set<String> citizenship) {
        List<CityEntity>list=new ArrayList<> ();
        for (String s : citizenship) {
            if (Objects.nonNull (repository.checkCity ( s ))) {
                list.add ( repository.checkCity ( s ) );
            }
        }
        return list;
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
