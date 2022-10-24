package com.example.project_blueprint.service.mail;

import com.example.project_blueprint.domains.auth.OTPEntity;
import com.example.project_blueprint.dto.EmailDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;


//    @Async
//    public void send(Map<String, String> args) {
//        try {
//            System.out.println(Thread.currentThread().getName());
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
//            mimeMessageHelper.setTo(Objects.requireNonNull(args.get("to")));
//            mimeMessageHelper.setSubject(Objects.requireNonNull(args.get("subject")));
//            mimeMessageHelper.setText(Objects.requireNonNull(args.get("text")));
//            mailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Done");
//    }
//
//    private void send(MimeMessage mimeMessage) {
//        mailSender.send(mimeMessage);
//    }
//
//    @Override
//    public void sendOTPMail(String receiver, String message) throws MessagingException {
//        Map<String, String> email = (Map<String, String>) Map.of(
//                "to", receiver,
//                "subject", "Verification code",
//                "text", message
//        );
//        send(email);
//    }

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
}
