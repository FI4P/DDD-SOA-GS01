package com.enzo.fiap.reup.dto.competencia;


import lombok.Builder;

@Builder
public record CompetenciaRequestDto(
        String nome,
        String descricao,
        String categoria
) {
}
