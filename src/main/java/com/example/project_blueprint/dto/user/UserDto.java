package com.example.project_blueprint.dto.user;

import com.example.project_blueprint.domains.auth.AuthRole;
import com.example.project_blueprint.dto.GenericDto;
import com.example.project_blueprint.enums.auth.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:16 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto extends GenericDto {

    private Long id;

    private String email;

    private Set<AuthRole> roles;

    private Boolean isActive;
}
