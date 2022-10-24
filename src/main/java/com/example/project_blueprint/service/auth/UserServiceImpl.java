package com.example.project_blueprint.service.auth;

import com.example.project_blueprint.configs.security.UserDetails;
import com.example.project_blueprint.domains.auth.AuthUser;
import com.example.project_blueprint.domains.auth.OTP;
import com.example.project_blueprint.domains.auth.UserInfo;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import com.example.project_blueprint.enums.auth.UserStatus;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.mappers.auth.UserMapper;
import com.example.project_blueprint.repository.auth.UserRepository;
import com.example.project_blueprint.service.mail.MailService;
import com.example.project_blueprint.service.otp.OTPService;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:27 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final OTPService otpService;
    private final MailService mailService;

    public UserServiceImpl(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, UserMapper userMapper, PasswordEncoder passwordEncoder, OTPService otpService, MailService mailService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.otpService = otpService;
        this.mailService = mailService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AuthUser authUser = getUserByEmail(email);
        return new com.example.project_blueprint.configs.security.UserDetails(authUser.getUserInfo());
    }

    private AuthUser getUserByEmail(String email) {
        AuthUser authUser = userRepository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("userInfo not found by email %s".formatted(email)));
        return authUser;
    }


    public JwtResponseDto checkOTP(String otp) {
        String email = otpService.checkOTP(otp);
        AuthUser authUser = getUserByEmail(email);
        UserInfo userInfo = authUser.getUserInfo();
        UserDetails userDetails = new UserDetails(userInfo);
        userDetails.userInfo().setStatus(UserStatus.ACTIVE);
        userDetails.userInfo().setIsActive(true);

        userRepository.save(authUser);

        String accessToken = JwtUtils.accessTokenService.generateToken(userDetails);
        String refreshToken = JwtUtils.refreshTokenService.generateToken(userDetails);

        return new JwtResponseDto(accessToken, refreshToken, "Bearer");
    }


    public void login(String email) {
        try {
            loadUserByUsername(email);
        } catch (UserNotFoundException e) {
            userRepository.save(AuthUser
                    .builder()
                    .email(email)
                    .userInfo(UserInfo.builder()
                            .email(email)
                            .build())
                    .build());
        } finally {
            OTP otp = otpService.generateOTP(email);
            mailService.send(otp);
        }
    }
}
