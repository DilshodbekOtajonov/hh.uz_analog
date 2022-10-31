package com.example.project_blueprint.dto.vacancy;

import com.example.project_blueprint.domains.address.City;
import com.example.project_blueprint.domains.specialization.Skill;
import com.example.project_blueprint.domains.specialization.Specialization;
import com.example.project_blueprint.domains.vacancy.ContactInfo;
import com.example.project_blueprint.enums.user.Experience;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 15:12 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
public class VacancyUpdateDTO {
    private Long id;
    private String title;
    private List<Specialization> specializations;
    private List<City> cityList;
    private Experience experience;
    private String description;
    private List<Skill> skillList;
    private ContactInfo contactInfo;
}
