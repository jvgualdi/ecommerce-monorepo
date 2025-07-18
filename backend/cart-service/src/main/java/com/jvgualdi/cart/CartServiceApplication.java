package com.jvgualdi.cart;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CartServiceApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(CartServiceApplication.class, args);
    }

}
