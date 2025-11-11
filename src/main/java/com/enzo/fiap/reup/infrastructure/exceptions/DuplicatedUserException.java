package com.enzo.fiap.reup.infrastructure.exceptions;

public class DuplicatedUserException extends RuntimeException {
    public DuplicatedUserException() {
        super("Já existe um usuário cadastrado com esse e-mail!");
    }
}
