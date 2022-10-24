package com.example.resume_service.controller;

import com.example.resume_service.domains.LanguageEntity;
import com.example.resume_service.dto.language.LanguageCreateDTO;
import com.example.resume_service.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 7:44 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Integer> createWorkspace(@Valid @RequestBody LanguageCreateDTO dto) {
        Integer save = service.save ( dto );
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LanguageEntity>> getAll() {
        List<LanguageEntity> city = service.getAll();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
