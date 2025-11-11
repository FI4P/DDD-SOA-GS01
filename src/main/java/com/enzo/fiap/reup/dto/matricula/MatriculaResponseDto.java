package com.enzo.fiap.reup.dto.matricula;

import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MatriculaResponseDto(
        Long id,
        UsuarioResponseDto usuario,
        TrilhaResponseDto trilha,
        LocalDateTime dataInscricao
) {
}
