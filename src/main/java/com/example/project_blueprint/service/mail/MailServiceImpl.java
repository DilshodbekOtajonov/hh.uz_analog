package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.domains.auth.OTP;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:36 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;


    @Override
    @Async
    public void send(OTP otp) {
        String receiver = otp.getEmail();
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(receiver);
            mailMessage.setFrom("dilshodbekotajonov95@gmail.com");
            mailMessage.setSubject("One Time password");
            mailMessage.setText(otp.getCode());
            mailSender.send(mailMessage);
            log.info("email sent to {}", receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Async
    public void send(String receiver, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("dilshodbekotajonov95@gmail.com");
            mailMessage.setTo(receiver);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            mailSender.send(mailMessage);
            log.info("email sent to {}", receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
