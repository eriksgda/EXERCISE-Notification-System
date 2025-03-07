package com.example.notification_system.controller;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.qualifier.Platform;
import com.example.notification_system.qualifier.PushQualifier;
import com.example.notification_system.service.LogService;
import com.example.notification_system.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService primaryEmailService;
    private final NotificationService smsService;
    private final NotificationService androidPushService;
    private final NotificationService iosPushService;
    private final LogService logService;

    @Autowired
    public NotificationController(
            NotificationService primaryEmailService,
            @Qualifier("sms") NotificationService smsService,
            @PushQualifier(platform = Platform.ANDROID) NotificationService androidPushService,
            @PushQualifier(platform = Platform.IOS) NotificationService iosPushService,
            LogService logService) {

        this.primaryEmailService = primaryEmailService;
        this.smsService = smsService;
        this.androidPushService = androidPushService;
        this.iosPushService = iosPushService;
        this.logService = logService;
    }

    @GetMapping("/email-default")
    public String defaultEmailNotification() {
        return this.primaryEmailService.sendNotification("Default email message");
    }

    @GetMapping("/sms")
    public String smsNotification() {
        return this.smsService.sendNotification("SMS alert");
    }

    @GetMapping("/android")
    public String androidPushNotification() {
        return this.androidPushService.sendNotification("Android alert");
    }

    @GetMapping("/ios")
    public String iosPushNotification() {
        return this.iosPushService.sendNotification("IOS alert");
    }

    @GetMapping("/logs")
    public List<NotificationLog> getLogs() {
        return this.logService.getLogs();
    }
}
