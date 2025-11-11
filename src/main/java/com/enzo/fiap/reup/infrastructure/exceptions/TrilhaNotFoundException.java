package com.enzo.fiap.reup.infrastructure.exceptions;

public class TrilhaNotFoundException extends RuntimeException {
    public TrilhaNotFoundException() {
        super("Trilha não encontrada!");
    }
}
