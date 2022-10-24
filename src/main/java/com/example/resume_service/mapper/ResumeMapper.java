package com.example.resume_service.mapper;

import com.example.resume_service.domains.ResumeEntity;
import com.example.resume_service.dto.resume.ResumeDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 6:10 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface ResumeMapper {
    ResumeDTO toDTO(ResumeEntity resume);
    List<ResumeDTO> toDTOList(List<ResumeEntity> resumeEntities);
}
