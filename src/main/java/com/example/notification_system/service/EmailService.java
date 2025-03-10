package com.example.notification_system.service;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.model.NotificationTypes;
import com.example.notification_system.repository.NotificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Primary
@Service
public class EmailService implements NotificationService{

    private final NotificationLogRepository repository;

    @Autowired
    public EmailService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public String sendNotification(String message) {
        String response = "Email sent: " + message;

        this.repository.save(NotificationLog.builder()
                .message(message)
                .notificationType(NotificationTypes.EMAIL)
                .platform(null)
                .timestamp(LocalDateTime.now()).build());

        return response;
    }
}
