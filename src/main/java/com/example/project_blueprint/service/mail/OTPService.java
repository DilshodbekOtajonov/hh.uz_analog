package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.dto.EmailDTO;
import com.example.project_blueprint.service.auth.UserService;
import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OTPService {

    private final OtpGenerator otpGenerator;
    private final MailServiceImpl emailService;

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

    public Boolean generateOtpForEmp(String userEmail)
    {
        // generate otp
        String otpValue = otpGenerator.generateOTPForEmployer(userEmail);
        if (otpValue.length() <8)
        {
            return  false;
        }


        // fetch user e-mail from database
        // String userEmail = userService.findEmailByUsername(userEmail);
        List<String> recipients = new ArrayList<>();
        recipients.add(userEmail);

        // generate emailDTO object
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSubject("Spring Boot OTP For Employer Password.");
        emailDTO.setBody("OTP Password: " + otpValue);
        emailDTO.setRecipients(recipients);

        // send generated e-mail
        return emailService.sendSimpleMessage(emailDTO);
    }

    public Boolean validateOTPForEmp(String key, String otp)
    {
        // get OTP from cache
        String cacheOTP = otpGenerator.getOPTForEmpByKey(key);
        if (cacheOTP!=null && cacheOTP.equals(otp))
        {
            otpGenerator.clearOTPForEmpFromCache(key);
            return true;
        }
        return false;
    }

    public Boolean generateUrl(String userEmail)
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
}
