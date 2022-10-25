package com.example.resume_service.service;

import com.example.resume_service.domains.WorkPlacesEntity;
import com.example.resume_service.dto.WorkPlacesCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:04 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class WorkPlacesService {


    public List<WorkPlacesEntity> save(List<WorkPlacesCreateDto> dto) {
        List<WorkPlacesEntity> workPlacesEntityList = new ArrayList<> ();

        for (WorkPlacesCreateDto workPlacesCreateDto : dto) {
            WorkPlacesEntity workPlaces = WorkPlacesEntity.builder ()
                    .startWork ( LocalDate.parse ( workPlacesCreateDto.getStartWork (), DateTimeFormatter.ISO_LOCAL_DATE ) )
                    .isEndWork ( workPlacesCreateDto.getIsEndWork () )
                    .endWork ( LocalDate.parse ( workPlacesCreateDto.getEndWork (), DateTimeFormatter.ISO_LOCAL_DATE ) )
                    .organization ( workPlacesCreateDto.getOrganization () )
                    .position ( workPlacesCreateDto.getPosition () )
                    .jobDuties ( workPlacesCreateDto.getJobDuties () )
                    .build ();
          workPlacesEntityList.add ( workPlaces );
        }

        return workPlacesEntityList;
    }



    public List<WorkPlacesEntity> checkWorkPlaces(List<WorkPlacesEntity> workPlacesId) {
        List<WorkPlacesEntity> workPlacesEntities = new ArrayList<> ();
        for (WorkPlacesEntity workPlaces : workPlacesId) {
            workPlacesEntities.add (  workPlaces);
        }
        return workPlacesEntities;
    }
}
