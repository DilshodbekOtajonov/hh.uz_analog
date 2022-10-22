package com.example.resume_service.controller;

import com.example.resume_service.service.WorkPlacesService;
import com.example.resume_service.domains.CityEntity;
import com.example.resume_service.domains.WorkPlacesEntity;
import com.example.resume_service.dto.workPlaces.WorkPlacesCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 7:18 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */

@RestController
@RequestMapping("workPlaces")
@RequiredArgsConstructor
public class WorkPlacesController {

    private final WorkPlacesService service;

    @PostMapping(value = "/create")
    public ResponseEntity<WorkPlacesEntity> createWorkspace(@Valid @RequestBody WorkPlacesCreateDto dto,Long id) {
        WorkPlacesEntity save = service.save ( dto,id);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkPlacesEntity>> getAll() {
        List<WorkPlacesEntity> city = service.getAll();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
