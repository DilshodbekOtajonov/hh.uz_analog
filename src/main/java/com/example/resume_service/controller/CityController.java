package com.example.resume_service.controller;

import com.example.resume_service.domains.CityEntity;
import com.example.resume_service.dto.CityCreateDto;
import com.example.resume_service.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 7:19 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService service;

    @PostMapping(value = "/create")
    public ResponseEntity<CityEntity> createWorkspace(@Valid @RequestBody CityCreateDto cityCreateDto) {
        CityEntity save = service.save ( cityCreateDto );
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CityEntity>> getAll() {
        List<CityEntity> city = service.getAll();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
