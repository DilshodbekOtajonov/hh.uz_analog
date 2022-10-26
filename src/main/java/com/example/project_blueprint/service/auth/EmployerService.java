package com.example.project_blueprint.service.auth;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project_blueprint.configs.encryption.Encoders;
import com.example.project_blueprint.configs.security.EmployerDetails;
import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.dto.employer.EmployerUpdateDto;
import com.example.project_blueprint.dto.employer.auth.EmployerRegisterDto;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.employer.auth.PasswordResetToken;
import com.example.project_blueprint.dto.employer.auth.ResetPasswordRequest;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.dto.user.UserUpdateDto;
import com.example.project_blueprint.exceptions.CommonUserException;
import com.example.project_blueprint.exceptions.OtpNotValidException;
import com.example.project_blueprint.exceptions.UserNotActiveException;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.handlers.response.AppErrorDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.handlers.response.ResponseEntity;
import com.example.project_blueprint.mappers.auth.EmployerMapper;
import com.example.project_blueprint.repository.EmployerRepository;
import com.example.project_blueprint.repository.auth.AuthUserRepository;
import com.example.project_blueprint.repository.auth.UserRepository;
import com.example.project_blueprint.service.mail.MailServiceImpl;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.service.mail.OtpGenerator;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import com.example.project_blueprint.validators.auth.EmployerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerService implements UserDetailsService {
    private final OTPService otpService;
    private final MailServiceImpl emailService;
    private final EmployerRepository repository;
    private final UserRepository userRepository;
    private final AuthUserService authService;
    private final EmployerMapper mapper;
    private final Encoders encoders;

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

    private String verifyToken(String token) {
        DecodedJWT decodedJWT = JwtUtils.accessTokenService.getVerifier().verify(token);
        String email = decodedJWT.getSubject();
        return email;
    }

    public void login(String email, String password) {
        Optional<Employer> byEmail = repository.findByEmailAndPassword(email, password);
        if (byEmail.isEmpty()) {
            loadUserByUsername(email);
        }
    }

    public EmployerDto register(EmployerRegisterDto dto) {
        Optional<User> byEmail = userRepository.findByEmail(dto.email());
        if (!byEmail.isEmpty()) {
            new CommonUserException("email %s already excists in job seekers category".formatted(dto.email()));
        }
        AuthUser authUser = authService.getAuthUserByEmail(dto.email());
        if (authService.validateAuthUser(authUser) != true) {
            otpService.generateOtpForEmp(dto.email());
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

    public Optional findUserByResetToken(String resetToken) {
        return repository.findByResetToken(resetToken);
    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        Employer employer = repository.findByEmail(email).get();
        if (employer != null) {
            employer.setResetToken(token);
            repository.save(employer);
        } else {
            throw new UserNotFoundException("Could not find any employer with the email " + email);
        }
    }

    public Employer getByResetPasswordToken(String token) {
        return repository.findByResetToken(token).get();
    }

    public void updatePassword(Employer employer, String newPassword) {
        String encodedPassword = encoders.passwordEncoder().encode(newPassword);
        employer.setPassword(encodedPassword);

        employer.setResetToken(null);
        repository.save(employer);
    }


    public PasswordResetToken getPassword(HttpServletRequest request, String email) {
        // Lookup employer in database by e-mail
        Optional<Employer> optional = repository.findByEmail(email);

        if (!optional.isPresent()) {
            new UserNotFoundException("Could not find any employer with the email " + email);
        }

        // Generate random 36-character string token for reset password
        Employer employer = optional.get();
        String token = JwtUtils.accessTokenService.generateToken(email);
        PasswordResetToken response = new PasswordResetToken(token);
        employer.setResetToken(token);

        // Save token to database
        repository.save(employer);

        String appUrl = request.getScheme() + "://" + request.getServerName();

        // Email message
        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("ffreeze0109@gmail.com");
        passwordResetEmail.setTo(employer.getEmail());
        passwordResetEmail.setSubject("Password Reset Request");
        passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                + "/reset?token=" + employer.getResetToken());

        emailService.sendEmail(passwordResetEmail);

        return response;
    }

    public void setPassword(ResetPasswordRequest request) {
        Optional<Employer> optional = repository.findByEmail(verifyToken(request.getToken()));

        if (!optional.isPresent()) {
            new UserNotFoundException("Could not find any employer with the email " + verifyToken(request.getToken()));
        }
        
        optional.get().setPassword(request.getPassword());
    }

    public ResponseEntity<DataDto<Boolean>> update(EmployerUpdateDto updateDto) {
        Optional<Employer> employer = repository.findById(updateDto.getId());
        if (employer.isEmpty()) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "employer not found")));
        }
        Employer authEmployer = employer.get();
        authEmployer.setEmail(updateDto.getEmail());
        authEmployer.setCompanyName(updateDto.getCompanyName());
        authEmployer.setPassword(updateDto.getPassword());
        authEmployer.setName(updateDto.getName());
        authEmployer.setPhoneNumber(updateDto.getPhoneNumber());
        authEmployer.setRegion(updateDto.getRegion());
        authEmployer.setSurName(updateDto.getSurName());
        repository.save(authEmployer);
        return new ResponseEntity<>(new DataDto<>(true));
    }
}
