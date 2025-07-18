package com.jvgualdi.notification.domain.service;

import com.jvgualdi.notification.domain.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(Notification notification) {

        log.info("Enviando notificação para user {}: {}",
                 notification.getUserId(), notification.getMessage());
    }
}