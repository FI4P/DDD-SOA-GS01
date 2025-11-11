package com.enzo.fiap.reup.mapper;


import com.enzo.fiap.reup.domain.competencia.Competencia;
import com.enzo.fiap.reup.domain.matricula.Matricula;
import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaRequestDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaResponseDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MatriculaMapper {


    private final UsuarioMapper usuarioMapper;
    private final TrilhaMapper trilhaMapper;

    public MatriculaMapper(UsuarioMapper usuarioMapper, TrilhaMapper trilhaMapper) {
        this.usuarioMapper = usuarioMapper;
        this.trilhaMapper = trilhaMapper;
    }

    //TODO: TrilhasDtos, e logica para evitar looping de serialização.
    public MatriculaResponseDto toResponse(Matricula matricula){

        UsuarioResponseDto usuarioResponseDto = usuarioMapper.toResponse(matricula.getUsuario(), false);
        TrilhaResponseDto trilhaResponseDto = trilhaMapper.toResponse(matricula.getTrilha(), false);

        return MatriculaResponseDto.builder()
                .id(matricula.getId())
                .usuario(usuarioResponseDto)
                .trilha(trilhaResponseDto)
                .dataInscricao(matricula.getDataInscricao())
                .build();


    }


    public Matricula toEntity(MatriculaRequestDto  matriculaRequestDto, Usuario usuario, Trilha trilha){
        return Matricula.builder()
                .usuario(usuario)
                .trilha(trilha)
                .build();

    }

}
