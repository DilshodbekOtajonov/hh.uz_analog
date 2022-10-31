package com.example.project_blueprint.enums.vacancy;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 21:14 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum Schedule {
    FULL_DAY,
    SHIFT_WORK,
    FLEXIBLE_SCHEDULE,
    DISTANT_WORK,
    SHIFT_METHOD;

    public static Schedule findBySchedule(String schedule){
        for (Schedule value : values()) {
            if (value.name().equalsIgnoreCase(schedule)){
                return value;
            }
        }
        return FULL_DAY;
    }
}
