package com.example.project_blueprint.service.auth;

import com.example.project_blueprint.configs.security.UserDetails;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.dto.auth.LoginRequestDto;
import com.example.project_blueprint.dto.user.UserDto;
import com.example.project_blueprint.dto.auth.UserRegisterDTO;
import com.example.project_blueprint.dto.jwt.JwtResponseDto;
import com.example.project_blueprint.exceptions.UserNotFoundException;
import com.example.project_blueprint.mappers.auth.UserMapper;
import com.example.project_blueprint.repository.auth.UserRepo;
import com.example.project_blueprint.utils.jwt.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
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
public class UserService implements UserDetailsService {
    private final UserRepo userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepository, @Lazy AuthenticationManager authenticationManager, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException("user not found by email %s".formatted(email)));
        return new com.example.project_blueprint.configs.security.UserDetails(user);
    }


    public JwtResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String accessToken = JwtUtils.accessTokenService.generateToken(userDetails);
        String refreshToken = JwtUtils.refreshTokenService.generateToken(userDetails);
        return new JwtResponseDto(accessToken, refreshToken, "Bearer");
    }

    public UserDto register(UserRegisterDTO dto) {
        User user = userRepository.save(User.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .build());
        return userMapper.fromUser(user);
    }
}
