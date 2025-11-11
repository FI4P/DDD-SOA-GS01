package com.enzo.fiap.reup.mapper;


import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    //TODO: MatriculaDTOs, e logica para evitar looping de serialização.
    public UsuarioResponseDto toResponse(Usuario usuario, boolean includeMatricula){

        return UsuarioResponseDto.builder()
                .id(usuario.getId())
                .nome(usuario.getName())
                .email(usuario.getEmail())
                .nivelCarreira(usuario.getNivelCarreira())
                .areaAtuacao(usuario.getAreaAtuacao())
                .roles(usuario.getRoles())
                .createdAt(usuario.getCreatedAt())
                .updatedAt(usuario.getUpdatedAt()).build();
    }


    public Usuario toEntity(UsuarioRequestDto usuarioRequestDto){
        return Usuario.builder()
                .name(usuarioRequestDto.nome())
                .email(usuarioRequestDto.email())
                .nivelCarreira(usuarioRequestDto.nivelCarreira())
                .areaAtuacao(usuarioRequestDto.areaAtuacao())
                .roles(usuarioRequestDto.roles())
                .build();
    }

}
