package com.example.resume_service.repository;

import com.example.resume_service.domains.WorkPlacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:06 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface WorkPlacesRepository extends JpaRepository<WorkPlacesEntity,Long> {
}
