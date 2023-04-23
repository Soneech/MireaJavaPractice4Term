package org.soneech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final String FROM_EMAIL = "spring-test-email@yandex.ru";
    private final String TO_EMAIL = "soneech@yandex.ru";
    private final String SUBJECT = "Saving new object. Spring practice";
    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendNotification(String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(TO_EMAIL);
        message.setFrom(FROM_EMAIL);
        message.setSubject(SUBJECT);
        message.setText(messageText);
        mailSender.send(message);
    }
}
