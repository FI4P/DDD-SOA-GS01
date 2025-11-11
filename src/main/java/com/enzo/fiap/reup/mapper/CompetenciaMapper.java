package com.enzo.fiap.reup.mapper;


import com.enzo.fiap.reup.domain.competencia.Competencia;
import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaRequestDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CompetenciaMapper {


    //TODO: TrilhasDtos, e logica para evitar looping de serialização.
    public CompetenciaResponseDto toResponse(Competencia competencia, boolean includeTrilhas){

        return CompetenciaResponseDto.builder()
                .id(competencia.getId())
                .nome(competencia.getNome())
                .descricao(competencia.getDescricao())
                .categoria(competencia.getCategoria())
                .createdAt(competencia.getCreatedAt())
                .updatedAt(competencia.getUpdatedAt())
                .build();

    }


    public Competencia toEntity(CompetenciaRequestDto competenciaRequestDto){
        return Competencia.builder()
                .nome(competenciaRequestDto.nome())
                .descricao(competenciaRequestDto.descricao())
                .categoria(competenciaRequestDto.categoria())
                .build();

    }

}
