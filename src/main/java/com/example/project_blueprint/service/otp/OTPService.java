package com.example.project_blueprint.service.otp;

import com.example.project_blueprint.domains.auth.OTP;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:16 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface OTPService {
    OTP getOTPByCode(String code);

    String checkOTP(OTP otp);
    String checkOTP(String otp);

    OTP generateOTP(String email);
}
