package com.example.notification_system.service;

import com.example.notification_system.model.NotificationLog;
import com.example.notification_system.repository.NotificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final NotificationLogRepository repository;

    @Autowired
    public LogService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    public List<NotificationLog> getLogs() {
        return this.repository.findAllByOrderByTimestampDesc();
    }
}
