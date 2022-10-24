package com.example.project_blueprint.mappers.auth;

import com.example.project_blueprint.domains.auth.UserInfo;
import com.example.project_blueprint.dto.auth.UserDto;
import org.mapstruct.Mapper;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:21 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromUser(UserInfo userInfo);
}
