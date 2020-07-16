package com.demo.service;

import com.sendgrid.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${send-grid.host}")
    private String host;

    @Value("${send-grid.send.endpoint}")
    private String endpoint;

    @Value("${send-grid.token}")
    private String token;

    public void sendEmail(Mail mail) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Mail> request = new HttpEntity<>(mail, headers);
        restTemplate.exchange(host + endpoint, HttpMethod.POST, request, Object.class);
    }
}
