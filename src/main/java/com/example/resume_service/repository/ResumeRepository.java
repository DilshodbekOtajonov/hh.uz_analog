package com.example.resume_service.repository;

import com.example.resume_service.domains.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 11:35 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
public interface ResumeRepository extends JpaRepository<ResumeEntity,Long> {
}
