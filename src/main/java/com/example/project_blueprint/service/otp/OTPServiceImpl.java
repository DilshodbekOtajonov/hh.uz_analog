package com.example.project_blueprint.service.otp;

import com.example.project_blueprint.domains.auth.OTP;
import com.example.project_blueprint.repository.auth.OTPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:17 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService {

    private final OTPRepository otpRepository;

    @Override
    public OTP getOTPByCode(String code) {
        OTP otp = otpRepository.findOTPByCode(code)
                .orElseThrow(() -> new RuntimeException("otp not found by code"));
        return otp;
    }

    @Override
    public String checkOTP(OTP otp) {
        if (otp.getIsUsed())
            throw new RuntimeException("OTP already used");
        else otp.setIsUsed(true);
        boolean isStillValid = otp.getValidTill().isAfter(LocalDateTime.now(Clock.systemDefaultZone()));
        if (!isStillValid) {
            throw new RuntimeException("OTP is not valid");
        }
        return otp.getEmail();
    }

    @Override
    public String checkOTP(String otp) {
        OTP otpByCode = getOTPByCode(otp);
        String resultMail = checkOTP(otpByCode);
        return resultMail;
    }

    @Override
    public OTP generateOTP(String email) {
        Random random = new Random();

        OTP otp = OTP.builder()
                .code(String.valueOf(random.nextInt(1000, 9999)))
                .email(email)
                .validTill(LocalDateTime.now(Clock.systemDefaultZone()).plusMinutes(1))
                .isUsed(false)
                .build();
        return otpRepository.save(otp);
    }
}
