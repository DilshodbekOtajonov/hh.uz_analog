package com.example.project_blueprint.dto.vacancy;

import com.example.project_blueprint.domains.address.Address;
import com.example.project_blueprint.domains.address.City;
import com.example.project_blueprint.domains.specialization.Skill;
import com.example.project_blueprint.domains.specialization.Specialization;
import com.example.project_blueprint.domains.vacancy.ContactInfo;
import com.example.project_blueprint.enums.user.Experience;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:46 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@Getter
@Setter
@Builder
public class VacancyDTO {
    private String title;
    private List<Specialization> specializations;
    private List<City> cityList;
    private Experience experience;
    private String description;
    private List<Skill> skillList;
    private ContactInfo contactInfo;
}
