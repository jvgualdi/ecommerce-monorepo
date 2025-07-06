package com.jvgualdi.catalog.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/actuator/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("UP");
    }
}