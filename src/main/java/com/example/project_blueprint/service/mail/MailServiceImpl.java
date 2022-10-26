package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;


    public Boolean sendSimpleMessage(EmailDTO emailDTO)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailDTO.getRecipients().stream().collect(Collectors.joining(",")));
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText(emailDTO.getBody());

        Boolean isSent = false;
        try
        {
            mailSender.send(mailMessage);
            isSent = true;
        }
        catch (Exception e) {
        }
        return isSent;
    }

    public Boolean sendUrlMessage(EmailDTO emailDTO)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailDTO.getRecipients().stream().collect(Collectors.joining(",")));
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText(emailDTO.getBody());

        Boolean isSent = false;
        try
        {
            mailSender.send(mailMessage);
            isSent = true;
        }
        catch (Exception e) {
        }
        return isSent;
    }
}
