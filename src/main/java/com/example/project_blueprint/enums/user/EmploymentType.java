package com.example.project_blueprint.enums.user;

import java.util.Arrays;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 14:48 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum EmploymentType {
    FULL_TIME,
    PART_TIME,
    ONE_TIME,
    VOLUNTEERING,
    INTERNSHIP;


    public static EmploymentType findByEmploymentType(String employmentType){
        for (EmploymentType value : values()) {
            if (value.name().equalsIgnoreCase(employmentType)){
                return value;
            }
        }
        return FULL_TIME;
    }
}
