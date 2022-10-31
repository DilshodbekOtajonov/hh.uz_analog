package com.example.project_blueprint.mappers.vacancy;

import com.example.project_blueprint.domains.vacancy.Vacancy;
import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import com.example.project_blueprint.dto.vacancy.VacancyUpdateDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 16:52 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface VacancyMapper {

    Vacancy toVacancy(VacancyDTO dto);
    Vacancy toVacancy(VacancyCreateDTO dto);
    Vacancy fromVacancyUpdateDTO(VacancyUpdateDTO dto);
    List<VacancyDTO> fromListVacancy(List<Vacancy> vacancyList);

    VacancyDTO fromVacancyCreateDTO(VacancyCreateDTO dto);

    VacancyDTO fromVacancy(Vacancy vacancy);
}
