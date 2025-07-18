package com.jvgualdi.notification.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private String id;
    private Long userId;
    private String message;
    private Instant timestamp;
}
