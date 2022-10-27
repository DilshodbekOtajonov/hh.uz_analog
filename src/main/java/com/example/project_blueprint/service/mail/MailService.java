package com.example.project_blueprint.service.mail;


import com.example.project_blueprint.dto.EmailDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface MailService {
    void sendSimpleMessage(EmailDTO emailDTO);

    void sendEmail(SimpleMailMessage email);
}
