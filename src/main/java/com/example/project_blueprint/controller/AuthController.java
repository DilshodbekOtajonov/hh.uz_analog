package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.VerifyTokenRequestDTO;
import com.example.project_blueprint.dto.auth.LoginRequestDto;
import com.example.project_blueprint.dto.auth.UserRegisterDto;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.dto.user.UserDto;
import com.example.project_blueprint.dto.user.UserUpdateDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.service.auth.UserService;
import com.example.project_blueprint.service.mail.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:55 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping(value = "/login", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void login(@RequestBody LoginRequestDto loginRequest) {
        service.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserRegisterDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value = "/verify")
    public ResponseEntity<JWTToken> verifyOtp(@Valid @RequestBody VerifyTokenRequestDTO verifyTokenRequest) {
        return new ResponseEntity<>(service.verifyOtp(verifyTokenRequest), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public com.example.project_blueprint.handlers.response.ResponseEntity<List<UserDto>> getAll() {
        com.example.project_blueprint.handlers.response.ResponseEntity<List<UserDto>> users = service.getAll();
        return users;
    }

    @PutMapping("/update/{id}")
    public com.example.project_blueprint.handlers.response.ResponseEntity<DataDto<Boolean>> update(@PathVariable(name = "id") Long id,
                                                                                                   @RequestBody UserUpdateDto dto) {
        dto.setId(id);
        com.example.project_blueprint.handlers.response.ResponseEntity<DataDto<Boolean>> response = service.update(dto);
        return response;
    }
}
