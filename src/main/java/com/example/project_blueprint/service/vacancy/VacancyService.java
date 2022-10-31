package com.example.project_blueprint.service.vacancy;

import com.example.project_blueprint.domains.vacancy.Vacancy;
import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import com.example.project_blueprint.dto.vacancy.VacancyUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:45 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface VacancyService {
    VacancyDTO create(VacancyCreateDTO dto);

    VacancyDTO update(VacancyUpdateDTO dto);

    void delete(Long id);

    VacancyDTO getOne(Long id);

    List<VacancyDTO> findAll();
    Vacancy getVacancyById(Long id);
}
