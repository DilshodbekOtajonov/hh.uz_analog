package com.example.project_blueprint.enums.vacancy;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 21:14 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum RespondentType {
    APPLICANT_WITH_DISABILITIES,
    APPLICANT_WITH_INCOMPLETE_RESUME,
    ONLY_WITH_COVER_LETTER;

    public static RespondentType findByRespondentType(String respondentType){
        for (RespondentType value : values()) {
            if (value.name().equalsIgnoreCase(respondentType)){
                return value;
            }
        }
        return null;
    }
}
