package com.example.project_blueprint.service.auth;

import com.example.project_blueprint.configs.encryption.Encoders;
import com.example.project_blueprint.configs.security.EmployerDetails;
import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.dto.employer.EmployerUpdateDto;
import com.example.project_blueprint.dto.employer.auth.*;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.jwt.JWTToken;
import com.example.project_blueprint.exceptions.CommonUserException;
import com.example.project_blueprint.exceptions.UserNotActiveException;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.handlers.response.AppErrorDto;
import com.example.project_blueprint.handlers.response.DataDto;
import com.example.project_blueprint.handlers.response.ResponseEntity;
import com.example.project_blueprint.mappers.auth.EmployerMapper;
import com.example.project_blueprint.repository.EmployerRepository;
import com.example.project_blueprint.repository.auth.UserRepository;
import com.example.project_blueprint.service.mail.MailServiceImpl;
import com.example.project_blueprint.service.mail.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerService implements UserDetailsService {
    private final OTPService otpService;
    private final MailServiceImpl emailService;
    private final EmployerRepository repository;
    private final UserRepository userRepository;
    private final EmployerMapper mapper;
    private final Encoders encoders;

    public ResponseEntity<List<EmployerDto>> getAll() {
        List<EmployerDto> employerDtos = new ArrayList<>();
        List<Employer> employers = repository.findAll();
        for (Employer employer : employers) {
            EmployerDto userDto = mapper.fromEmployer(employer);
            //userDto.setAuthRole(authEmployer.getRole());
            employerDtos.add(userDto);
        }
        return new ResponseEntity<>(employerDtos);
    }

    @Override
    public EmployerDetails loadUserByUsername(String email) throws UserNotFoundException {

        Employer employer = repository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("employer not found by email %s".formatted(email)));
        return new EmployerDetails(employer);
    }

//    private String verifyToken(String token) {
//        DecodedJWT decodedJWT = JwtUtils.accessTokenService.getVerifier().verify(token);
//        String email = decodedJWT.getSubject();
//        return email;
//    }

    public void login(EmpLoginRequestDto dto) {
        Optional<Employer> byEmail = repository.findByEmailAndPassword(dto.email(), dto.password());
        if (byEmail.isEmpty()) {
            Employer employer = repository.save(Employer.builder()
                    .email(dto.email())
                    .build());
            throw new UserNotFoundException("Employer not found with email %s".formatted(dto.email()));
        }
    }

    public EmployerDto register(EmployerRegisterDto dto) {
        Optional<User> byEmail = userRepository.findByEmail(dto.email());
        if (!byEmail.isEmpty()) {
            throw new CommonUserException("Already excisting email in job seekers category. Not allowed email %s".formatted(dto.email()));
        }
        Optional<Employer> the_employer = repository.findByEmail(dto.email());
        if (!the_employer.isEmpty()) {
            if (the_employer.get().getStatus().equals(Employer.EmployerStatus.IN_ACTIVE)) {
                otpService.generateOtpForEmp(dto.email());
                new UserNotActiveException("Email not active. Otp sent to email %s".formatted(dto.email()));
            }
            return mapper.fromEmployer(the_employer.get());
        }
        Employer employer = Employer.builder()
                .email(dto.email())
                .name(dto.name())
                .surName(dto.surName())
                .companyName(dto.companyName())
                .phoneNumber(dto.phoneNumber())
                .region(dto.region())
                .build();
        repository.save(employer);
        otpService.generateOtpForEmp(dto.email());
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


    public PasswordResetToken getPassword(HttpServletRequest request, EmpGetPasswordDto dto) {
        // Lookup employer in database by e-mail
        Optional<Employer> optional = repository.findByEmail(dto.email());

        if (optional.isEmpty()) {
            throw new UserNotFoundException("Could not find any employer with the email " + dto.email());
        }

        // Generate random 36-character string token for reset password
        //Employer employer = optional.get();
        String token = JwtUtils.accessTokenService.generateToken(dto.email());
        PasswordResetToken response = new PasswordResetToken(token);
        optional.get().setResetToken(token);

        // Save token to database
      //  repository.save(employer);

        String appUrl = request.getScheme() + "://" + request.getServerName();

        // Email message
        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("ffreeze0109@gmail.com");
        passwordResetEmail.setTo(optional.get().getEmail());
        passwordResetEmail.setSubject("Password Reset Request");
        passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                + "/set-password?token=" + optional.get().getResetToken());

        emailService.sendEmail(passwordResetEmail);

        return response;
    }

    public void setPassword(ResetPasswordRequest request) {
        Optional<Employer> optional = findUserByResetToken(request.getToken());

        if (!optional.isPresent()) {
            throw new UserNotFoundException("Could not find any employer with the email " + JwtUtils.accessTokenService.getSubject(request.getToken()));
        }
        updatePassword(optional.get(), request.getPassword());
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

    public JWTToken verifyOtp(VerifyForEmpTokenRequestDTO verifyTokenRequest) {
        String email = verifyTokenRequest.getEmail();
        String otp = verifyTokenRequest.getOtp();

        boolean isOtpValid = otpService.validateOTPForEmp(email, otp);
        if (!isOtpValid) {
            new org.springframework.http.ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Employer> byEmail = repository.findByEmail(verifyTokenRequest.getEmail());
        if (byEmail.isEmpty()) {
            Employer employer = Employer.builder()
                    .email(verifyTokenRequest.getEmail())
                    .build();
        }
        byEmail.get().setStatus(Employer.EmployerStatus.ACTIVE);
        String token = JwtUtils.accessTokenService.generateToken(email);
        JWTToken response = new JWTToken(token);
        return response;
    }
}
