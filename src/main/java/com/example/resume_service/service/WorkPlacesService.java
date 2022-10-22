package com.example.resume_service.service;

import com.example.resume_service.domains.WorkPlacesEntity;
import com.example.resume_service.dto.workPlaces.WorkPlacesCreateDto;
import com.example.resume_service.repository.WorkPlacesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:04 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class WorkPlacesService {
    private final WorkPlacesRepository rep;

    public WorkPlacesEntity save(WorkPlacesCreateDto dto,Long id) {
        WorkPlacesEntity workPlaces=WorkPlacesEntity.builder ()
                .createdBy ( id )
                .startWork ( LocalDate.parse ( dto.getStartWork (), DateTimeFormatter.ISO_LOCAL_DATE ) )
                .isEndWork ( dto.getIsEndWork () )
                .endWork ( LocalDate.parse ( dto.getEndWork (),DateTimeFormatter.ISO_LOCAL_DATE ) )
                .organization ( dto.getOrganization () )
                .position ( dto.getPosition () )
                .jobDuties ( dto.getJobDuties () )
        .build ();

        return rep.save ( workPlaces );
    }

    public List<WorkPlacesEntity>getAll(){
        return rep.findAll ();
    }
}
