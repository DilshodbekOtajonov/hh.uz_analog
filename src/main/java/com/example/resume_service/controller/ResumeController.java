package com.example.resume_service.controller;

import com.example.resume_service.domains.ResumeEntity;
import com.example.resume_service.dto.resume.ResumeCreateDTO;
import com.example.resume_service.dto.resume.ResumeDTO;
import com.example.resume_service.response.ApiResponse;
import com.example.resume_service.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:32 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

  private final ResumeService resumeService;

  @PostMapping(value = "/create")
  public ApiResponse<ResumeEntity> create(@RequestBody  @Valid ResumeCreateDTO createDTO){
    return new ApiResponse<> ( resumeService.save (  createDTO ));
  }

  @GetMapping
  public ApiResponse<List<ResumeDTO>> getAll() {
    List<ResumeDTO> city = resumeService.getAll ();
    return new ApiResponse<> ( city );
  }



}
