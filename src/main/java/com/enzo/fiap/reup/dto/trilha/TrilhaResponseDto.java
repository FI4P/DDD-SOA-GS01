package com.enzo.fiap.reup.dto.trilha;


import com.enzo.fiap.reup.domain.trilha.Nivel;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record TrilhaResponseDto(
        Long id,
        String name,
        String descricao,
        Nivel nivel,
        int cargaHoraria,
        String focoPrincipal,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
