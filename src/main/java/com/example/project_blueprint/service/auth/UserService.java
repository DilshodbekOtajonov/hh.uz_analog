package com.example.project_blueprint.service.auth;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project_blueprint.domains.auth.CustomUserDetails;

import com.example.project_blueprint.domains.auth.OTPEntity;
import com.example.project_blueprint.dto.auth.UserRegisterDto;
import com.example.project_blueprint.dto.auth.UserRegisterWithOtpDto;
import com.example.project_blueprint.dto.user.UserDto;
import com.example.project_blueprint.enums.auth.UserStatus;
import com.example.project_blueprint.response.ResponseEntity;

import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.mappers.auth.UserMapper;
import com.example.project_blueprint.repository.auth.AuthRoleRepository;
import com.example.project_blueprint.repository.auth.UserRepository;

import com.example.project_blueprint.service.mail.MailService;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import com.example.project_blueprint.utils.jwt.Utils;
import com.example.project_blueprint.validators.auth.UserValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.validation.Valid;
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
public class UserService
        implements UserDetailsService {
    private final AuthRoleRepository authRoleRepository;
    private final MailService mailService;
    private OTPService otpService;

    private final UserRepository repository;
    private final UserValidator validator;
    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(AuthRoleRepository authRoleRepository, MailService mailService, UserRepository repository, UserValidator validator, @Lazy AuthenticationManager authenticationManager, UserMapper mapper, PasswordEncoder passwordEncoder, Utils utils) {
        this.authRoleRepository = authRoleRepository;
        this.mailService = mailService;
        this.repository = repository;
        this.validator = validator;
        this.authenticationManager = authenticationManager;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

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


    public void login(String email){
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
        User user = repository.save(User.builder()
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build());
        return mapper.fromUser(user);
    }
}
