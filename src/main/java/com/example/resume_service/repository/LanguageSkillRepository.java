package com.example.resume_service.repository;

import com.example.resume_service.domains.LanguageSkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 7:16 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
public interface LanguageSkillRepository extends JpaRepository<LanguageSkillsEntity,Long> {
}
