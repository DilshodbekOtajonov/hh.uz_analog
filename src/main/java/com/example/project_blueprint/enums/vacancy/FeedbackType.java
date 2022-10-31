package com.example.project_blueprint.enums.vacancy;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 21:13 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum FeedbackType {
    VERIFIED_ONLY,EVERYONE;

    public static FeedbackType findByFeedbackType(String feedbackType){
        for (FeedbackType value : values()) {
            if (value.name().equalsIgnoreCase(feedbackType)){
                return value;
            }
        }
        return VERIFIED_ONLY;
    }
}
