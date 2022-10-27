package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.auth.LoginRequestDto;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.employer.EmployerUpdateDto;
import com.example.project_blueprint.dto.employer.auth.*;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.service.auth.EmployerService;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth/employer")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerService service;
    private final OTPService otpService;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<JwtResponseDto> login(@RequestBody EmpLoginRequestDto loginRequest) {
        return ResponseEntity.ok(service.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<EmployerDto> register(@Valid @RequestBody EmployerRegisterDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value = "/verify")
    public ResponseEntity<JWTToken> verifyOtp(@Valid @RequestBody VerifyForEmpTokenRequestDTO verifyTokenRequest)
    {
        return new ResponseEntity<>(service.verifyOtp(verifyTokenRequest), HttpStatus.OK);
    }

    //forgot password
    @PostMapping("/get-password")
    public ResponseEntity<PasswordResetToken> getPassword(HttpServletRequest request, @Valid @RequestBody EmpGetPasswordDto email) {
        return ResponseEntity.ok(service.getPassword(request, email));
    }

    //reset password
    @PostMapping("/set-password")
    public void setPassword(@Valid @RequestBody ResetPasswordRequest request) {
        service.setPassword(request);
    }

    @GetMapping("/getAll")
    public com.example.project_blueprint.handlers.response.ResponseEntity<List<EmployerDto>> getAll() {
        com.example.project_blueprint.handlers.response.ResponseEntity<List<EmployerDto>> users = service.getAll();
        return users;
    }

    @PutMapping("/update/{id}")
    public com.example.project_blueprint.handlers.response.ResponseEntity<DataDto<Boolean>> update(@PathVariable(name = "id") Long id,
                                                                                                   @RequestBody EmployerUpdateDto dto) {
        dto.setId(id);
        com.example.project_blueprint.handlers.response.ResponseEntity<DataDto<Boolean>> response = service.update(dto);
        return response;
    }
}
