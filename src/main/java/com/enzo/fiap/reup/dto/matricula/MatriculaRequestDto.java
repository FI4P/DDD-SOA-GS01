package com.enzo.fiap.reup.dto.matricula;


import lombok.Builder;

@Builder
public record MatriculaRequestDto(
        Long usuarioId,
        Long trilhaId
) {
}
