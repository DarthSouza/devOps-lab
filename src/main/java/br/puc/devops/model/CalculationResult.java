package br.puc.devops.model;

public record CalculationResult(
        Double sum,
        Double subtract,
        Double multiply,
        Double divide,
        String error
) {
}

