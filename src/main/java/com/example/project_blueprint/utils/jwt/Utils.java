package com.example.project_blueprint.utils.jwt;

import com.example.project_blueprint.domains.auth.OTPEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class Utils {

    public static OTPEntity generateOTP(String email) {
        Random random = new Random();
        int randomPin = random.nextInt(1000, 9999);
        return OTPEntity.builder()
                .email(email)
                .code(randomPin)
                .validTill(LocalDateTime.now().plusMinutes(1))
                .build();
    }
}
