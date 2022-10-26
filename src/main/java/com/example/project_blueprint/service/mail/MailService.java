package com.example.project_blueprint.service.mail;


import com.example.project_blueprint.dto.EmailDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface MailService {
    Boolean sendSimpleMessage(EmailDTO emailDTO);
}
