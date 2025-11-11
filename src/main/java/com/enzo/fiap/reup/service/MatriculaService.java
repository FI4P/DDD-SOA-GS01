package com.enzo.fiap.reup.service;


import com.enzo.fiap.reup.domain.competencia.Competencia;
import com.enzo.fiap.reup.domain.matricula.Matricula;
import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaRequestDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaResponseDto;
import com.enzo.fiap.reup.infrastructure.exceptions.*;
import com.enzo.fiap.reup.mapper.CompetenciaMapper;
import com.enzo.fiap.reup.mapper.MatriculaMapper;
import com.enzo.fiap.reup.repository.CompetenciaRepository;
import com.enzo.fiap.reup.repository.MatriculaRepository;
import com.enzo.fiap.reup.repository.TrilhaRepository;
import com.enzo.fiap.reup.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {


    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;
    private final MatriculaMapper matriculaMapper;
    private final MatriculaRepository matriculaRepository;

    public MatriculaService(UsuarioRepository usuarioRepository, TrilhaRepository trilhaRepository, MatriculaMapper matriculaMapper, MatriculaRepository matriculaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.trilhaRepository = trilhaRepository;
        this.matriculaMapper = matriculaMapper;
        this.matriculaRepository = matriculaRepository;
    }

    public MatriculaResponseDto create(MatriculaRequestDto dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(UserNotFoundException::new);
        Trilha trilha = trilhaRepository.findById(dto.trilhaId()).orElseThrow(TrilhaNotFoundException::new);


        Matricula matricula = matriculaMapper.toEntity(dto, usuario, trilha);

        matriculaRepository.save(matricula);

        return matriculaMapper.toResponse(matricula);
    }

    public List<MatriculaResponseDto> index() {

        List<Matricula> matriculas = matriculaRepository.findAll();

        List<MatriculaResponseDto> matriculaResponseDtos = matriculas.stream().map(m -> matriculaMapper.toResponse(m)).toList();

        return matriculaResponseDtos;
    }

    public MatriculaResponseDto show(Long id) {

        Matricula matricula = matriculaRepository.findById(id).orElseThrow(MatriculaNotFoundException::new);

        return matriculaMapper.toResponse(matricula);
    }


    public void delete(Long id) {

        Matricula matricula = matriculaRepository.findById(id).orElseThrow(MatriculaNotFoundException::new);

        matriculaRepository.delete(matricula);

    }

}
