package com.example.resume_service.controller;

import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.dto.country.CountryCreateDTO;
import com.example.resume_service.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 1:36 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;

    @PostMapping(value = "/create")
    public ResponseEntity<CountryEntity> createWorkspace(@Valid @RequestBody CountryCreateDTO dto) {
        CountryEntity save = service.save ( dto );
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getAll() {
        List<CountryEntity> city = service.getAll();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
