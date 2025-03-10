package com.example.notification_system.service;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.model.NotificationTypes;
import com.example.notification_system.repository.NotificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Qualifier("sms")
public class SMSService implements NotificationService{

    private final NotificationLogRepository repository;

    @Autowired
    public SMSService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public String sendNotification(String message) {
        String response = "SMS sent: " + message;

        this.repository.save(NotificationLog.builder()
                .message(message)
                .notificationType(NotificationTypes.SMS)
                .platform(null)
                .timestamp(LocalDateTime.now()).build());

        return response;
    }
}
