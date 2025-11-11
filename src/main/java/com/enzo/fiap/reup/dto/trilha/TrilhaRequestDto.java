package com.enzo.fiap.reup.dto.trilha;


import com.enzo.fiap.reup.domain.trilha.Nivel;
import lombok.Builder;

@Builder
public record TrilhaRequestDto(
        String nome,
        String descricao,
        Nivel nivel,
        Integer cargaHoraria,
        String focoPrincipal,
        String competencias
) {

}
