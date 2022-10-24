package com.example.resume_service.repository;

import com.example.resume_service.domains.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 1:27 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface CountryRepository extends JpaRepository<CountryEntity,Integer> {
    @Query("select t from CountryEntity t where t.countryName=:name")
    Optional<CountryEntity> checkCountryName(@Param ( "name" ) String countryName);
}
