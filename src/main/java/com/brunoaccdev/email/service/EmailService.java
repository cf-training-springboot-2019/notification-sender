package com.brunoaccdev.email.service;

import com.brunoaccdev.email.dto.SendEmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void send(SendEmailRequest request) {
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setTo(request.getEmail());
        mailMsg.setSubject(request.getSubject());
        mailMsg.setText(request.getMessage());
        log.info("Sending email: {}", mailMsg);
        mailSender.send(mailMsg);
    }
}
