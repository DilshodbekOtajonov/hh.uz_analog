package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.dto.EmailDTO;
import com.example.project_blueprint.service.auth.UserService;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

@Service
public class OTPService {

    private OtpGenerator otpGenerator;
    private MailServiceImpl emailService;
    private UserService userService;

    public Boolean generateOtp(String userEmail)
    {
        // generate otp
        Integer otpValue = otpGenerator.generateOTP(userEmail);
        if (otpValue == -1)
        {
            return  false;
        }


        // fetch user e-mail from database
        // String userEmail = userService.findEmailByUsername(userEmail);
        List<String> recipients = new ArrayList<>();
        recipients.add(userEmail);

        // generate emailDTO object
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSubject("Spring Boot OTP Password.");
        emailDTO.setBody("OTP Password: " + otpValue);
        emailDTO.setRecipients(recipients);

        // send generated e-mail
        return emailService.sendSimpleMessage(emailDTO);
    }

    public Boolean validateOTP(String key, Integer otpNumber)
    {
        // get OTP from cache
        Integer cacheOTP = otpGenerator.getOPTByKey(key);
        if (cacheOTP!=null && cacheOTP.equals(otpNumber))
        {
            otpGenerator.clearOTPFromCache(key);
            return true;
        }
        return false;
    }
}
