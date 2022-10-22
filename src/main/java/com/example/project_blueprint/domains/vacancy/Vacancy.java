package com.example.project_blueprint.domains.vacancy;

import com.example.project_blueprint.domains.address.Address;
import com.example.project_blueprint.domains.address.City;
import com.example.project_blueprint.enums.user.Experience;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 4:35 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
public class Vacancy {
    private Long id;
    private String title;
    private Integer specializationId;
    private City city;
    private Address address;
    private Experience experience;
    private String description;
    private List<String> skillList;
    private ContactInfo contactInfo;

}
