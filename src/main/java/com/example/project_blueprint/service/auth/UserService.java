package com.example.project_blueprint.service.auth;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project_blueprint.domains.auth.CustomUserDetails;

import com.example.project_blueprint.dto.VerifyTokenRequestDTO;
import com.example.project_blueprint.dto.auth.LoginRequestDto;
import com.example.project_blueprint.dto.auth.UserRegisterDto;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.dto.user.UserDto;
import com.example.project_blueprint.dto.user.UserUpdateDto;
import com.example.project_blueprint.exceptions.UserNotActiveException;
import com.example.project_blueprint.handlers.response.AppErrorDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.handlers.response.ResponseEntity;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.mappers.auth.UserMapper;
import com.example.project_blueprint.repository.auth.UserRepository;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:27 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Service
@Transactional
@RequiredArgsConstructor
public class UserService
        implements UserDetailsService {
    private final OTPService otpService;
    private final UserRepository repository;
    private final UserMapper mapper;

    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> authUsers = repository.findAll();
        for (User authUser : authUsers) {
                UserDto userDto = mapper.fromUser(authUser);
                //userDto.setAuthRole(authUser.getRole());
                userDtos.add(userDto);
        }
        return new ResponseEntity<>(userDtos);
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("user not found by email %s".formatted(email)));
        return new CustomUserDetails(user);
    }

    public void login(LoginRequestDto dto) {
        Optional<User> byEmail = repository.findByEmail(dto.email());
        if (byEmail.isEmpty()) {
            User user = repository.save(User.builder()
                    .email(dto.email())
                    .build());
        }
        if (byEmail.get().getStatus().equals(User.UserStatus.IN_ACTIVE)) {
            otpService.generateOtp(dto.email());
            throw new UserNotActiveException("Email not active. Otp sent to email %s".formatted(dto.email()));
        }
    }

    public UserDto register(UserRegisterDto dto) {
        Optional<User> authUser = repository.findByEmail(dto.email());
        if (!authUser.isEmpty()) {
            if (authUser.get().getStatus().equals(User.UserStatus.IN_ACTIVE)) {
                otpService.generateOtp(dto.email());
                new UserNotActiveException("Email not active. Otp sent to email %s".formatted(dto.email()));
            }
            return mapper.fromUser(authUser.get());
        }
        User user = User.builder()
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .fullName(dto.firstName()+" "+dto.lastName())
                .build();
        repository.save(user);
        otpService.generateOtp(dto.email());
        return mapper.fromUser(user);
    }

    public ResponseEntity<DataDto<Boolean>> update(UserUpdateDto updateDto) {
        Optional<User> user = repository.findById(updateDto.getId());
        if (user.isEmpty()) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "user not found")));
        }
        User authUser = user.get();
        authUser.setEmail(updateDto.getEmail());
        authUser.setFullName(updateDto.getFullName());
        authUser.setPassword(updateDto.getPassword());
        authUser.setMobilePhoneNumber(updateDto.getPhoneNumber());
        authUser.setJobSearchArea(updateDto.getJobSearchArea());
        authUser.setSocialNetworks(updateDto.getSocialMedia());
        repository.save(authUser);
        return new ResponseEntity<>(new DataDto<>(true));
    }

    public JWTToken verifyOtp(VerifyTokenRequestDTO verifyTokenRequest) {
        String email = verifyTokenRequest.getEmail();
        Integer otp = verifyTokenRequest.getOtp();

        boolean isOtpValid = otpService.validateOTP(email, otp);
        if (!isOtpValid) {
            new org.springframework.http.ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<User> authUser = repository.findByEmail(verifyTokenRequest.getEmail());
        if (!authUser.isEmpty()) {
            authUser.get().setStatus(User.UserStatus.ACTIVE);
        }
        String token = JwtUtils.accessTokenService.generateToken(email);
        JWTToken response = new JWTToken(token);
        return response;
    }
}
