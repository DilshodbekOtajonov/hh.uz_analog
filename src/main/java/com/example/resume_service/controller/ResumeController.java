package com.example.resume_service.controller;

import com.example.resume_service.dto.ResumeCreateDTO;
import com.example.resume_service.service.ResumeService;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:32 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
public class ResumeController {

  private final ResumeService resumeService;

//  public ResponseEntity<ResponseEntity> create(Long id , @RequestBody @Valid ResumeCreateDTO createDTO){
////    ResponseEntity save = resumeService.save ( id, createDTO );
//    return new ResponseEntity<> ( HttpStatus.CREATED);
//  }



}
