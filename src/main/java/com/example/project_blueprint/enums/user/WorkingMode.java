package com.example.project_blueprint.enums.user;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 21:16 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum WorkingMode {
    SAT_SUN,
    PER_DAY_4_6,
    AFTER_16;

    public static WorkingMode findByWorkingMode(String workingMode){
        for (WorkingMode mode : values()) {
            if (mode.name().equalsIgnoreCase(workingMode)){
                return mode;
            }
        }
        return SAT_SUN;
    }
}
