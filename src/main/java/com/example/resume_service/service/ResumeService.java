package com.example.resume_service.service;

import com.example.resume_service.domains.CityEntity;
import com.example.resume_service.domains.ResumeEntity;
import com.example.resume_service.dto.ResumeCreateDTO;
import com.example.resume_service.enums.Floor;
import com.example.resume_service.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:32 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class ResumeService {

    private final CityService cityService;

    private final ResumeRepository repository;
    public ResumeEntity save(Long userId, ResumeCreateDTO dto) {

        CityEntity cityEntity = cityService.checkCity ( dto.getCity () );
        List<CityEntity> list = cityService.checkCity ( dto.getCitizenship () );

        ResumeEntity resume=ResumeEntity.builder ()
                .name ( dto.getName () )
                .surname ( dto.getSurname () )
                .phone ( dto.getPhone () )
                .city (cityEntity )
                .dateOfBirth ( LocalDate.parse ( dto.getDateOfBirth(), DateTimeFormatter.ISO_LOCAL_DATE ))
                .floor ( Floor.findByName ( dto.getFloor () ))
//                .citizenship (list)
                .workExperience ( Boolean.parseBoolean (dto.getWorkExperience ()) )






                .build ();


//        ResumeEntity save = repository.save ( resume );
        return null;
    }
}
