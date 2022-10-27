package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Async
    public void sendSimpleMessage(EmailDTO emailDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailDTO.getRecipients().stream().collect(Collectors.joining(",")));
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText(emailDTO.getBody());

        mailSender.send(mailMessage);
//        Boolean isSent = false;
//        try {
//            mailSender.send(mailMessage);
//            isSent = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isSent;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }
}
