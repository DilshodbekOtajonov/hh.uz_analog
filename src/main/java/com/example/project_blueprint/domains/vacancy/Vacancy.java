package com.example.project_blueprint.domains.vacancy;

import com.example.project_blueprint.domains.Auditable;
import com.example.project_blueprint.domains.specialization.Skill;
import com.example.project_blueprint.domains.address.City;
import com.example.project_blueprint.domains.specialization.Specialization;
import com.example.project_blueprint.enums.user.Experience;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 4:35 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vacancy extends Auditable {

    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Specialization> specializations;
    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cityList;

    @Enumerated(EnumType.STRING)
    private Experience experience;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skillList;

    @OneToOne
    private ContactInfo contactInfo;

    @Builder(builderMethodName = "childBuilder")
    public Vacancy(Long id, Boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, List<Specialization> specializations, List<City> cityList, Experience experience, String description, List<Skill> skillList, ContactInfo contactInfo) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.specializations = specializations;
        this.cityList = cityList;
        this.experience = experience;
        this.description = description;
        this.skillList = skillList;
        this.contactInfo = contactInfo;
    }
}
