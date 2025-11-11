package com.enzo.fiap.reup.dto.competencia;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CompetenciaResponseDto(
        Long id,
        String nome,
        String descricao,
        String categoria,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
