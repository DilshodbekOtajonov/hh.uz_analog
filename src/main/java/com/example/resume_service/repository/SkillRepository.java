package com.example.resume_service.repository;

import com.example.resume_service.domains.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 3:08 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface SkillRepository extends JpaRepository<SkillEntity,Long> {
}
