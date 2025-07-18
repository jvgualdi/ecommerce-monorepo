package com.jvgualdi.cart.service;

import com.jvgualdi.cart.domain.entity.CartItem;
import com.jvgualdi.cart.domain.repository.CartItemRepository;
import com.jvgualdi.cart.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartItemRepository repository;

    @Override
    @CacheEvict(value = "cart", key = "#userId")
    public CartItem addItem(Long userId, Long productId, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        CartItem item = new CartItem(UUID.randomUUID().toString(), userId, productId, quantity);
        return repository.save(item);
    }

    @Override
    @Cacheable(value = "cart", key = "#userId")
    public List<CartItem> getCart(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    @CacheEvict(value = "cart", key = "#userId")
    public void removeItem(Long userId, String itemId) {
        repository.findById(itemId).ifPresent(item -> {
            if (!item.getUserId().equals(userId)) {
                throw new SecurityException("Cannot remove item from another user's cart");
            }
            repository.delete(item);
        });
    }

    @Override
    @CacheEvict(value = "cart", key = "#userId")
    public void clearCart(Long userId) {
        List<CartItem> items = repository.findByUserId(userId);
        repository.deleteAll(items);
    }
}
