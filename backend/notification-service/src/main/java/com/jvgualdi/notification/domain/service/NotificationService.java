package com.jvgualdi.notification.domain.service;

import com.jvgualdi.notification.domain.entity.Notification;

public interface NotificationService {
    void sendNotification(Notification notification);
}