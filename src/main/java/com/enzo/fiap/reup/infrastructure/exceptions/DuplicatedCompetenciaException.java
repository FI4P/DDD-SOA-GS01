package com.enzo.fiap.reup.infrastructure.exceptions;

public class DuplicatedCompetenciaException extends RuntimeException {
    public DuplicatedCompetenciaException() {
        super("Já existe uma competencia com esse nome!");
    }
}
