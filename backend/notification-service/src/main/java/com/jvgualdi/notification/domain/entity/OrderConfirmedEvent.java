package com.jvgualdi.notification.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderConfirmedEvent {
    private String orderId;
    private Long userId;
    private List<OrderItem> items;

    @Data
    public static class OrderItem {
        private Long productId;
        private Integer quantity;
    }
}