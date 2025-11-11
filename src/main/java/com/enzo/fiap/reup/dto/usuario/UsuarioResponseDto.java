package com.enzo.fiap.reup.dto.usuario;

import com.enzo.fiap.reup.domain.usuario.NivelCarreira;
import com.enzo.fiap.reup.domain.usuario.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


@Builder

public record UsuarioResponseDto(
        Long id,
        String nome,
        String email,
        NivelCarreira nivelCarreira,
        String areaAtuacao,
        UserRoles roles,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){

}
