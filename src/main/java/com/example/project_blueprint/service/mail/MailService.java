package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.domains.auth.OTP;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/23/22 5:36 PM (Sunday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface MailService {

    void send(OTP otp);

    void send(String receiver, String subject, String text);
}
