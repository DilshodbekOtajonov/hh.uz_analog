package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import com.example.project_blueprint.dto.vacancy.VacancyUpdateDTO;
import com.example.project_blueprint.service.vacancy.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 4:27 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PostMapping("/create")
    public ResponseEntity<VacancyDTO> createVacancy(@RequestBody VacancyCreateDTO dto) {
        VacancyDTO vacancyDTO = vacancyService.create(dto);
        return new ResponseEntity<>(vacancyDTO,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VacancyDTO> updateVacancy(@RequestBody VacancyUpdateDTO dto){
        VacancyDTO vacancyDTO=vacancyService.update(dto);
        return new ResponseEntity<>(vacancyDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable Long id){
       vacancyService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyDTO> getOne(@PathVariable Long id){
        VacancyDTO vacancyDTO=vacancyService.getOne(id);
        return new ResponseEntity<>(vacancyDTO,HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<VacancyDTO>> findAll(){
        List<VacancyDTO> vacancyDTOS = vacancyService.findAll();
        return new ResponseEntity<>(vacancyDTOS,HttpStatus.OK);
    }
}
