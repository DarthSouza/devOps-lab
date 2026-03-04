package br.puc.devops.model;

import java.time.LocalDateTime;

public record WelcomeResponse(
        String message,
        String version,
        LocalDateTime timestamp
) {
}

