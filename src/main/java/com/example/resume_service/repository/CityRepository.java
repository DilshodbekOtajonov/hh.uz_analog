package com.example.resume_service.repository;

import com.example.resume_service.domains.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 5:05 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity,Integer> {
   @Query("select t from CityEntity t where t.cityName=:city ")
    Optional<CityEntity> checkCity(@Param ( "city" ) String city);
}
