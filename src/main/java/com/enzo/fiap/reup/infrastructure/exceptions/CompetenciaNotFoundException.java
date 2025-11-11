package com.enzo.fiap.reup.infrastructure.exceptions;

public class CompetenciaNotFoundException extends RuntimeException {
    public CompetenciaNotFoundException() {
        super("Competência não encontrada!");
    }
}
