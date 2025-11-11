package com.enzo.fiap.reup.infrastructure.exceptions;

public class MatriculaNotFoundException extends RuntimeException {
    public MatriculaNotFoundException() {
        super("Matricula não encontrada!");
    }
}
