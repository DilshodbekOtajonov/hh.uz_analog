package com.example.resume_service.mapper;

import com.example.resume_service.domains.LanguageSkillsEntity;
import com.example.resume_service.dto.LanguageSkillsCreateDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 5:13 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */

@Mapper(componentModel = "spring")
public interface LanguageSkillMapper {

    List<LanguageSkillsEntity> toDTOList(List<LanguageSkillsCreateDto> workspaceList);
}