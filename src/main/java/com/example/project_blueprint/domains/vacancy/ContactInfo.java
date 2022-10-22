package com.example.project_blueprint.domains.vacancy;

import com.example.project_blueprint.enums.user.EmploymentType;
import com.example.project_blueprint.enums.user.WorkingMode;
import com.example.project_blueprint.enums.vacancy.FeedbackType;
import com.example.project_blueprint.enums.vacancy.RespondentType;
import com.example.project_blueprint.enums.vacancy.Schedule;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 4:58 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
public class ContactInfo {
    private Long id;
    private String descriptionOfCompany;
    private Long employerId;
    private EmploymentType employmentType;
    private WorkingMode workingMode;
    private Boolean isChatEnabled;
    private FeedbackType feedbackType;
    private Schedule schedule;
    private RespondentType respondentType;

}
