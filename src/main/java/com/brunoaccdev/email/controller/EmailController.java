package com.brunoaccdev.email.controller;

import com.brunoaccdev.email.dto.SendEmailRequest;
import com.brunoaccdev.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public HttpEntity<HttpStatus> sendEmail(@RequestBody @Valid SendEmailRequest request) {
        emailService.send(request);
        return new HttpEntity<>(HttpStatus.OK);
    }

}
