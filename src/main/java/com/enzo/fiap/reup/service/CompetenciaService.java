package com.enzo.fiap.reup.service;


import com.enzo.fiap.reup.domain.competencia.Competencia;

import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;

import com.enzo.fiap.reup.infrastructure.exceptions.CompetenciaNotFoundException;
import com.enzo.fiap.reup.infrastructure.exceptions.DuplicatedCompetenciaException;

import com.enzo.fiap.reup.mapper.CompetenciaMapper;
import com.enzo.fiap.reup.repository.CompetenciaRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    public CompetenciaService(CompetenciaRepository competenciaRepository, CompetenciaMapper competenciaMapper) {
        this.competenciaRepository = competenciaRepository;
        this.competenciaMapper = competenciaMapper;
    }

    public CompetenciaResponseDto create(CompetenciaRequestDto dto) {
        Optional<Competencia> duplicatedCompetencia = competenciaRepository.findByNome(dto.nome());

        duplicatedCompetencia.ifPresent(competencia -> {
            throw new DuplicatedCompetenciaException();
        });

        Competencia competencia = competenciaMapper.toEntity(dto);

        competenciaRepository.save(competencia);

        return competenciaMapper.toResponse(competencia, false);
    }

    public List<CompetenciaResponseDto> index() {

        List<Competencia> competencias = competenciaRepository.findAll();

        List<CompetenciaResponseDto> usersResponseDto = competencias.stream().map(c -> competenciaMapper.toResponse(c, false)).toList();

        return usersResponseDto;
    }

    public CompetenciaResponseDto show(Long id) {

        Competencia competencia = competenciaRepository.findById(id).orElseThrow(CompetenciaNotFoundException::new);

        return competenciaMapper.toResponse(competencia, false);
    }


    public void update(Long id, CompetenciaRequestDto dto) {

        Competencia competencia = competenciaRepository.findById(id).orElseThrow(CompetenciaNotFoundException::new);

        competencia.setNome(dto.nome() != null ? dto.nome() : competencia.getNome());
        competencia.setDescricao(dto.descricao() != null ? dto.nome() : competencia.getDescricao());
        competencia.setCategoria(dto.categoria() != null ? dto.categoria() : competencia.getCategoria());

        competenciaRepository.save(competencia);

    }

    public void delete(Long id) {

        Competencia competencia = competenciaRepository.findById(id).orElseThrow(CompetenciaNotFoundException::new);

        competenciaRepository.delete(competencia);

    }

}
