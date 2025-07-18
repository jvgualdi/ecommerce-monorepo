package com.jvgualdi.cart.api;

import com.jvgualdi.cart.domain.entity.CartItem;
import com.jvgualdi.cart.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @PostMapping("/{userId}/items")
    public ResponseEntity<CartItem> addItem(@PathVariable Long userId,
                                            @RequestParam Long productId,
                                            @RequestParam Integer quantity) {
        CartItem created = service.addItem(userId, productId, quantity);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getCart(userId));
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<Void> removeItem(@PathVariable Long userId,
                                           @PathVariable String itemId) {
        service.removeItem(userId, itemId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        service.clearCart(userId);
        return ResponseEntity.noContent().build();
    }

}