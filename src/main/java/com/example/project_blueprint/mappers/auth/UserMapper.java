package com.example.project_blueprint.mappers.auth;

import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:21 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromUser(User user);

}
