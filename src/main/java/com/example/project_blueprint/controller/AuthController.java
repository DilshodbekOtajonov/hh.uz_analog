package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.auth.LoginRequestDto;
import com.example.project_blueprint.dto.auth.UserDto;
import com.example.project_blueprint.dto.auth.UserRegisterDTO;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import com.example.project_blueprint.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:55 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserRegisterDTO dto) {
        return  ResponseEntity.ok(userService.register(dto));
    }


}
