package br.puc.devops.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> welcome() {
        return ResponseEntity.ok(Map.of(
                "message", "Bem-vindo ao DevOps Lab! 🚀",
                "version", "1.0.0",
                "timestamp", LocalDateTime.now().toString()
        ));
    }

}

