package com.enzo.fiap.reup.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
}
