package com.example.notification_system.service;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.model.NotificationTypes;
import com.example.notification_system.qualifier.Platform;
import com.example.notification_system.qualifier.PushQualifier;
import com.example.notification_system.repository.NotificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@PushQualifier(platform = Platform.IOS)
public class IOSPushService implements NotificationService{

    private final NotificationLogRepository repository;

    @Autowired
    public IOSPushService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public String sendNotification(String message) {
        String response = "IOS push notification: " + message;

        this.repository.save(NotificationLog.builder()
                .message(message)
                .notificationType(NotificationTypes.PUSH)
                .platform(Platform.IOS).build());

        return response;
    }
}
