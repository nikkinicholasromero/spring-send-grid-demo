package com.demo.controller;

import com.demo.service.EmailService;
import com.sendgrid.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PutMapping("/")
    public void sendEmail(@RequestBody Mail mail) {
        emailService.sendEmail(mail);
    }
}
