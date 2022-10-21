package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import com.example.project_blueprint.service.vacancy.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 4:27 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@RestController
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping("/create")
    public ResponseEntity<VacancyDTO> createVacancy(@RequestBody VacancyCreateDTO dto) {

        VacancyDTO vacancyDTO = vacancyService.create(dto);
        return new ResponseEntity(vacancyDTO, HttpStatus.CREATED);
    }
}
