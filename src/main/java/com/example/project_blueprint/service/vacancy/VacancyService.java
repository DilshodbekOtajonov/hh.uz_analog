package com.example.project_blueprint.service.vacancy;

import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:45 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface VacancyService {
    VacancyDTO create(VacancyCreateDTO dto);
}
