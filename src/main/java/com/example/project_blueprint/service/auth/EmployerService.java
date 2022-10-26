package com.example.project_blueprint.service.auth;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project_blueprint.configs.security.EmployerDetails;
import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.dto.employer.auth.EmployerRegisterDto;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.exceptions.OtpNotValidException;
import com.example.project_blueprint.exceptions.UserNotActiveException;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.handlers.response.ResponseEntity;
import com.example.project_blueprint.mappers.auth.EmployerMapper;
import com.example.project_blueprint.repository.EmployerRepository;
import com.example.project_blueprint.repository.auth.AuthUserRepository;
import com.example.project_blueprint.service.mail.MailServiceImpl;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.service.mail.OtpGenerator;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import com.example.project_blueprint.validators.auth.EmployerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerService implements UserDetailsService {
    private final MailServiceImpl mailService;
    private final OTPService otpService;
    private final EmployerRepository repository;
    private final AuthUserService authService;
    private final EmployerMapper mapper;

    public ResponseEntity<List<EmployerDto>> getAll() {
        List<EmployerDto> employerDtos = new ArrayList<>();
        List<Employer> employers = repository.findAll();
        return new ResponseEntity<>(employerDtos);
    }

    @Override
    public EmployerDetails loadUserByUsername(String email) throws UserNotFoundException {

        Employer employer = repository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("employer not found by email %s".formatted(email)));
        return new EmployerDetails(employer);
    }

    private EmployerDetails verifyToken(String token) {
        DecodedJWT decodedJWT = JwtUtils.accessTokenService.getVerifier().verify(token);
        String email = decodedJWT.getSubject();
        return loadUserByUsername(email);
    }


    public void login(String email, String password) {
        Optional<Employer> byEmail = repository.findByEmail(email);
        if (byEmail.isEmpty()) {
            Employer employer = repository.save(Employer.builder()
                    .email(email)
                    .password(password)
                    .build());
        }
        otpService.generateOtpForEmp(email);
    }

    public EmployerDto register(EmployerRegisterDto dto) {
        otpService.generateOtpForEmp(dto.email());
        AuthUser authUser = authService.getAuthUserByEmail(dto.email());
        if (authService.validateAuthUser(authUser) != true) {
            new UserNotActiveException("user not active by email %s".formatted(dto.email()));
        }
        Employer employer = repository.save(Employer.builder()
                .email(dto.email())
                .name(dto.name())
                .surName(dto.surName())
                .companyName(dto.companyName())
                .phoneNumber(dto.phoneNumber())
                .region(dto.region())
                .build());
        repository.save(employer);
        return mapper.fromEmployer(employer);
    }

    ///////////////////////////////////////////////////////
    public String getPassword(String password) {
        otpService.generateUrl(password);
        return null;
    }

    public String setPassword(String password) {
        return password;
    }
}
