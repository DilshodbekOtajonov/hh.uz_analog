package com.example.project_blueprint.service.auth;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.domains.auth.CustomUserDetails;

import com.example.project_blueprint.dto.auth.UserRegisterDto;
import com.example.project_blueprint.dto.auth.UserRegisterWithOtpDto;
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
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final AuthUserService authService;
    private final UserRepository repository;
    private final UserMapper mapper;

    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> authUsers = repository.findAll();
        return new ResponseEntity<>(userDtos);
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("user not found by email %s".formatted(email)));
        return new CustomUserDetails(user);
    }

    private UserDetails verifyToken(String token) {
        DecodedJWT decodedJWT = JwtUtils.accessTokenService.getVerifier().verify(token);
        String email = decodedJWT.getSubject();
        return loadUserByUsername(email);
    }


    public void login(String email) {
        Optional<User> byEmail = repository.findByEmail(email);
        if (byEmail.isEmpty()) {
            User user = repository.save(User.builder()
                    .email(email)
                    .build());
        }
        otpService.generateOtp(email);
    }

    public Boolean registerWithOtp(UserRegisterWithOtpDto dto) {
        return otpService.generateOtp(dto.email());
    }

    public UserDto register(UserRegisterDto dto) {
        AuthUser authUser = authService.getAuthUserByEmail(dto.email());
        if (authUser.getIsActive()!=true) {
            new UserNotActiveException("user not active by email %s".formatted(dto.email()));
        }
        User user = User.builder()
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build();
        repository.save(user);
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
}
