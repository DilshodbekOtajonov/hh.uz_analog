package com.example.project_blueprint.controller;

import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.dto.VerifyTokenRequestDTO;
import com.example.project_blueprint.dto.auth.UserRegisterDto;
import com.example.project_blueprint.dto.auth.UserRegisterWithOtpDto;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.dto.user.UserDto;
import com.example.project_blueprint.dto.user.UserUpdateDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.repository.auth.AuthUserRepository;
import com.example.project_blueprint.service.auth.AuthUserService;
import com.example.project_blueprint.service.auth.UserService;
import com.example.project_blueprint.service.mail.MailService;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    private final OTPService otpService;

    private final AuthUserService authService;

    @PostMapping(value = "/login", produces = "application/json")
    public void login(@RequestBody String email) throws MessagingException {
        service.login(email);
    }

    @PostMapping("/register-with-otp")
    public ResponseEntity<Boolean> register(@Valid @RequestBody UserRegisterWithOtpDto dto) {
        return ResponseEntity.ok(service.registerWithOtp(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserRegisterDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value = "/verify")
    public org.springframework.http.ResponseEntity<JWTToken> verifyOtp(@Valid @RequestBody VerifyTokenRequestDTO verifyTokenRequest)
    {
        String email = verifyTokenRequest.getEmail();
        Integer otp = verifyTokenRequest.getOtp();

        boolean isOtpValid = otpService.validateOTP(email, otp);
        if (!isOtpValid) {
            return new org.springframework.http.ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        authService.create(verifyTokenRequest);

        String token = JwtUtils.accessTokenService.generateToken(email);
        JWTToken response = new JWTToken(token);


        return new org.springframework.http.ResponseEntity<>(response, HttpStatus.OK);
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
