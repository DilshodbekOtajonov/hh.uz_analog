package com.example.project_blueprint.enums.auth;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:12 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public enum UserStatus {
    ACTIVE,
    IN_ACTIVE;

    public static UserStatus findByUserStatus(String status){
        for (UserStatus userStatus : values()) {
            if (userStatus.name().equalsIgnoreCase(status)){
                return userStatus;
            }
        }
        return IN_ACTIVE;
    }
}
