package com.example.resume_service.repository;

import com.example.resume_service.domains.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:25 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface ExperienceRepository extends JpaRepository<ExperienceEntity,Long> {
}
