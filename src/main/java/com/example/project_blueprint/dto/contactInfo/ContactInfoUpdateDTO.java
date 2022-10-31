package com.example.project_blueprint.dto.contactInfo;

import com.example.project_blueprint.domains.language.Language;
import com.example.project_blueprint.enums.user.EmploymentType;
import com.example.project_blueprint.enums.user.WorkingMode;
import com.example.project_blueprint.enums.vacancy.FeedbackType;
import com.example.project_blueprint.enums.vacancy.RespondentType;
import com.example.project_blueprint.enums.vacancy.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 26/10/22 14:56 (Wednesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Getter
@Setter
public class ContactInfoUpdateDTO {
    private String descriptionOfCompany;
    private Long employerId;
    private EmploymentType employmentType;
    private WorkingMode workingMode;
    private Boolean isChatEnabled;
    private FeedbackType feedbackType;
    private Schedule schedule;
    private RespondentType respondentType;
    private List<Language> languages;
}
