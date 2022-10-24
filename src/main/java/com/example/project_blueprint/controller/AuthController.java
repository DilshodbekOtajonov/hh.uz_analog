package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.auth.UserDto;
import com.example.project_blueprint.dto.auth.UserRegisterDTO;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import com.example.project_blueprint.service.auth.UserService;
import com.example.project_blueprint.service.auth.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestParam String email) {
        userService.login(email);
        return "email sent successfully";
    }

    @PostMapping(value = "/checkOTP", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<JwtResponseDto> checkOTP(@RequestParam String otp) {
        return new ResponseEntity<>(userService.checkOTP(otp), HttpStatus.OK);
    }



}
