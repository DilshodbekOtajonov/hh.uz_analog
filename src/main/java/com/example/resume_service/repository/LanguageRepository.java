package com.example.resume_service.repository;

import com.example.resume_service.domains.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 7:05 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */


public interface LanguageRepository extends JpaRepository<LanguageEntity,Integer> {
   @Query("select t from LanguageEntity t where t.languageName=:language")
    Optional <LanguageEntity> checkLanguageName(@Param ( "language" ) String language);
}
