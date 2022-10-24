package com.example.resume_service.repository;

import com.example.resume_service.domains.WorkPlacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:06 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface WorkPlacesRepository extends JpaRepository<WorkPlacesEntity,Long> {

    @Query("select t from WorkPlacesEntity t where t.id=:id")
    Optional<WorkPlacesEntity> checkWorkPlaces(@Param ( "id" ) WorkPlacesEntity s);
}
