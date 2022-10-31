package com.example.project_blueprint.enums.vacancy;

/**
 * @author "Tojaliyev Asliddin"
 * @since 22/10/22 23:40 (Saturday)
 * hh.uz_analog/IntelliJ IDEA
 */
public enum PublicationType {
    PREMIUM,STANDARD_PLUS_AUTO_UPDATE,STANDARD_NO_UPDATE,ANONYMOUS_HIDDEN_SELECTION;

    public static PublicationType findByPublicationType(String publicationType){
        for (PublicationType value : values()) {
            if (value.name().equalsIgnoreCase(publicationType)){
                return value;
            }
        }
        return STANDARD_PLUS_AUTO_UPDATE;
    }
}
