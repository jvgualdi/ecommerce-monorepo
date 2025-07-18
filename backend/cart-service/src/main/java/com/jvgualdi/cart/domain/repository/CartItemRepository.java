package com.jvgualdi.cart.domain.repository;

import com.jvgualdi.cart.domain.entity.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, String> {
    List<CartItem> findByUserId(Long userId);
}
