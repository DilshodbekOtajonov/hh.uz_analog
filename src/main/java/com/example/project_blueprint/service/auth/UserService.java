package com.example.project_blueprint.service.auth;

import com.example.project_blueprint.dto.auth.UserDto;
import com.example.project_blueprint.dto.auth.UserRegisterDTO;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:10 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface UserService extends UserDetailsService {

    JwtResponseDto checkOTP(String otp);

    void login(String email);
}
