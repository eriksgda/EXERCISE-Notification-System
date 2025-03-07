package com.example.notification_system.model;

public enum NotificationTypes {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String type;

    NotificationTypes(String type) {
        this.type = type;
    }
}
