package com.example.resume_service.domains;

import com.example.resume_service.enums.CurrencyType;
import com.example.resume_service.enums.Floor;
import com.example.resume_service.enums.Level;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:31 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

//@Table(schema = "resume_schema")
public class ResumeEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String phone;

    @OneToOne
    private CityEntity city;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Floor floor;
    @OneToMany
    private List<CountryEntity> citizenship;

    @Column(columnDefinition = "bool default false")
    private boolean workExperience;

    private String career;

    private Integer salary;

    @Enumerated(value = EnumType.STRING)
    private CurrencyType currencyType;
    @OneToOne
    private ExperienceEntity education;

    @Enumerated(value = EnumType.STRING)
    private Level level;
    @OneToMany
    private List<LanguageSkillsEntity> languageSkills;



    @Builder(builderClassName = "childBuilder")

    public ResumeEntity(Timestamp createdAt, Timestamp updatedAt, Long createdBy, Long updatedBy, boolean deleted, Long id, String name, String surname, String phone, CityEntity city, LocalDate dateOfBirth, Floor floor, List<CountryEntity> citizenship, boolean workExperience, String career, Integer salary, CurrencyType currencyType, ExperienceEntity education, Level level, List<LanguageSkillsEntity> languageSkills) {
        super ( createdAt, updatedAt, createdBy, updatedBy, deleted );
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.floor = floor;
        this.citizenship = citizenship;
        this.workExperience = workExperience;
        this.career = career;
        this.salary = salary;
        this.currencyType = currencyType;
        this.education = education;
        this.level = level;
        this.languageSkills = languageSkills;
    }
}
