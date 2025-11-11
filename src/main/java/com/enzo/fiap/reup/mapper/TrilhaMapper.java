package com.enzo.fiap.reup.mapper;


import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.trilha.TrilhaRequestDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TrilhaMapper {


    //TODO: MatriculaDTOs, e logica para evitar looping de serialização.
    public TrilhaResponseDto toResponse(Trilha trilha, boolean includeMatriculas){

        return TrilhaResponseDto.builder()
                .id(trilha.getId())
                .name(trilha.getName())
                .descricao(trilha.getDescricao())
                .nivel(trilha.getNivel())
                .cargaHoraria(trilha.getCargaHoraria())
                .focoPrincipal(trilha.getFocoPrincipal())
                .createdAt(trilha.getCreatedAt())
                .updatedAt(trilha.getUpdatedAt())
                .build();
    }


    public Trilha toEntity(TrilhaRequestDto trilhaRequestDto){
        return Trilha.builder()
                .name(trilhaRequestDto.nome())
                .descricao(trilhaRequestDto.descricao())
                .nivel(trilhaRequestDto.nivel())
                .cargaHoraria(trilhaRequestDto.cargaHoraria())
                .focoPrincipal(trilhaRequestDto.focoPrincipal())
                .competencias(new ArrayList<>())
                .build();

    }

}
