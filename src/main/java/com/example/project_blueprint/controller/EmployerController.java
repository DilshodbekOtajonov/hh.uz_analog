package com.example.project_blueprint.controller;

import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.employer.auth.EmpGetPasswordDto;
import com.example.project_blueprint.dto.employer.auth.EmpLoginRequestDto;
import com.example.project_blueprint.dto.employer.auth.EmployerRegisterDto;
import com.example.project_blueprint.dto.employer.auth.VerifyForEmpTokenRequestDTO;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.repository.auth.AuthUserRepository;
import com.example.project_blueprint.service.auth.AuthUserService;
import com.example.project_blueprint.service.auth.EmployerService;
import com.example.project_blueprint.service.mail.MailServiceImpl;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth/employer")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerService service;
    private final AuthUserService authService;
    private final OTPService otpService;

    private final MailServiceImpl emailService;

    @PostMapping(value = "/login", produces = "application/json")
    public void login(@RequestBody EmpLoginRequestDto dto) {
        service.login(dto.email(), dto.password());
    }

    @PostMapping("/get-password")
    public ResponseEntity<String> getPassword() {
        return ResponseEntity.ok(service.getPassword(String.valueOf(HttpStatus.OK)));
    }

    @PostMapping("/set-password")
    public ResponseEntity<String> setPassword(@Valid @RequestBody EmpGetPasswordDto dto) {
        return ResponseEntity.ok(service.setPassword(dto.password()));
    }

    @PostMapping("/register")
    public ResponseEntity<EmployerDto> register(@Valid @RequestBody EmployerRegisterDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value = "/verify")
    public org.springframework.http.ResponseEntity<JWTToken> verifyOtp(@Valid @RequestBody VerifyForEmpTokenRequestDTO verifyTokenRequest)
    {
        String email = verifyTokenRequest.getEmail();
        String otp = verifyTokenRequest.getOtp();

        boolean isOtpValid = otpService.validateOTPForEmp(email, otp);
        if (!isOtpValid) {
            return new org.springframework.http.ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        authService.createForEmp(verifyTokenRequest);

        String token = JwtUtils.accessTokenService.generateToken(email);
        JWTToken response = new JWTToken(token);


        return new org.springframework.http.ResponseEntity<>(response, HttpStatus.OK);
    }
}
