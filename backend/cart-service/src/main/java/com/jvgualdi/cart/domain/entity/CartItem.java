package com.jvgualdi.cart.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "CartItem", timeToLive = 1800)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    private String id;
    private Long userId;
    private Long productId;
    private Integer quantity;

}
