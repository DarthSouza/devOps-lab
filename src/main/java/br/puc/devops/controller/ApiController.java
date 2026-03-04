package br.puc.devops.controller;

import br.puc.devops.model.CalculationResult;
import br.puc.devops.model.WelcomeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        return ResponseEntity.ok("Olá, " + name + "! Bem-vindo ao DevOps Lab! 🚀");
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b) {

        if (a == null || b == null) {
            return ResponseEntity.badRequest()
                    .body("Parâmetros 'a' e 'b' são obrigatórios");
        }

        var result = new CalculationResult(
                a + b,
                a - b,
                a * b,
                b != 0 ? a / b : null,
                b == 0 ? "Divisão por zero não permitida" : null
        );

        return ResponseEntity.ok(result);
    }

}

