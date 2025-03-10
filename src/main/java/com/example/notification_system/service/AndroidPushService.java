package com.example.notification_system.service;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.model.NotificationTypes;
import com.example.notification_system.qualifier.Platform;
import com.example.notification_system.qualifier.PushQualifier;
import com.example.notification_system.repository.NotificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@PushQualifier(platform = Platform.ANDROID)
public class AndroidPushService implements NotificationService{

    private final NotificationLogRepository repository;

    @Autowired
    public AndroidPushService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public String sendNotification(String message) {
        String response = "Android push notification: " + message;

        this.repository.save(NotificationLog.builder()
                .message(message)
                .notificationType(NotificationTypes.PUSH)
                .platform(Platform.ANDROID)
                .timestamp(LocalDateTime.now()).build());

        return response;
    }
}
