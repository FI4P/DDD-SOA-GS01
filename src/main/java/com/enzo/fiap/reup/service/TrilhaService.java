package com.enzo.fiap.reup.service;


import com.enzo.fiap.reup.domain.competencia.Competencia;
import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaRequestDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.infrastructure.exceptions.TrilhaNotFoundException;
import com.enzo.fiap.reup.infrastructure.exceptions.UserNotFoundException;
import com.enzo.fiap.reup.mapper.CompetenciaMapper;
import com.enzo.fiap.reup.mapper.TrilhaMapper;
import com.enzo.fiap.reup.repository.CompetenciaRepository;
import com.enzo.fiap.reup.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class TrilhaService {

    public final TrilhaMapper trilhaMapper;
    public final TrilhaRepository trilhaRepository;
    public final CompetenciaRepository competenciaRepository;
    public final CompetenciaMapper competenciaMapper;
    private final CompetenciaService competenciaService;


    public TrilhaService(TrilhaMapper trilhaMapper, TrilhaRepository trilhaRepository, CompetenciaRepository competenciaRepository, CompetenciaMapper competenciaMapper, CompetenciaService competenciaService) {
        this.trilhaMapper = trilhaMapper;
        this.trilhaRepository = trilhaRepository;
        this.competenciaRepository = competenciaRepository;
        this.competenciaMapper = competenciaMapper;
        this.competenciaService = competenciaService;
    }

    public TrilhaResponseDto create(TrilhaRequestDto trilhaRequestDto){

        Trilha trilha = trilhaMapper.toEntity(trilhaRequestDto);

        List<String> competenciasDto  = List.of(trilhaRequestDto.competencias().split(","));
        List<Competencia> competenciasExistentes = competenciaRepository.findByNomeIn(competenciasDto);
        List<String> competenciasExistentesStrings = competenciasExistentes.stream().map(competencia -> competencia.getNome()).toList();

        competenciasDto.forEach(compentencia -> {
            if(!competenciasExistentesStrings.contains(compentencia)){
                CompetenciaRequestDto competenciaRequestDto = CompetenciaRequestDto.builder().nome(compentencia).categoria(compentencia).descricao(compentencia).build();
                competenciaService.create(competenciaRequestDto);
                competenciasExistentes.add(competenciaMapper.toEntity(competenciaRequestDto));
            }
        });

        competenciasExistentes.forEach(competencia -> trilha.getCompetencias().add(competencia));

        trilhaRepository.save(trilha);

        return trilhaMapper.toResponse(trilha, false);

    }


    public List<TrilhaResponseDto> index(){
        List<TrilhaResponseDto> trilhasResponseDto = trilhaRepository.findAll().stream().map(trilha -> trilhaMapper.toResponse(trilha, false)).toList();
        return trilhasResponseDto;

    }


    public TrilhaResponseDto show(Long id){
        Trilha trilha = trilhaRepository.findById(id).orElseThrow(TrilhaNotFoundException::new);
        return trilhaMapper.toResponse(trilha, false);

    }


    public void update(Long id, TrilhaRequestDto dto){

        Trilha trilha =  trilhaRepository.findById(id).orElseThrow(TrilhaNotFoundException::new);


        //TODO: Logica para alterar compentencias
        trilha.setName(dto.nome() != null ? dto.nome() : trilha.getName());
        trilha.setDescricao(dto.descricao() != null ? dto.descricao() : trilha.getDescricao());
        trilha.setNivel(dto.nivel() != null ? dto.nivel() : trilha.getNivel());
        trilha.setCargaHoraria(dto.cargaHoraria() != null ? dto.cargaHoraria() : trilha.getCargaHoraria());

        trilhaRepository.save(trilha);


    }

    public void delete(Long id){

        Trilha trilha = trilhaRepository.findById(id).orElseThrow(TrilhaNotFoundException::new);

        trilhaRepository.delete(trilha);

    }







}
