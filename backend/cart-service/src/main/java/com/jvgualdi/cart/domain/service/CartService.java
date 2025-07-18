package com.jvgualdi.cart.domain.service;

import com.jvgualdi.cart.domain.entity.CartItem;

import java.util.List;

public interface CartService {
    CartItem addItem(Long userId, Long productId, Integer quantity);
    List<CartItem> getCart(Long userId);
    void removeItem(Long userId, String itemId);
    void clearCart(Long userId);
}
