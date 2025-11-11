package com.enzo.fiap.reup.controller;

import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaRequestDto;
import com.enzo.fiap.reup.dto.matricula.MatriculaResponseDto;
import com.enzo.fiap.reup.service.CompetenciaService;
import com.enzo.fiap.reup.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {


    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDto> create(@Valid  @RequestBody MatriculaRequestDto body){
        MatriculaResponseDto matriculaResponseDto = matriculaService.create(body);

        URI uri = URI.create("/matriculas/" + matriculaResponseDto.id());

        return ResponseEntity.created(uri).body(matriculaResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDto>> index(){
        List<MatriculaResponseDto> matriculaResponseDtos = matriculaService.index();
        return ResponseEntity.ok(matriculaResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDto> show(@PathVariable Long id){
        MatriculaResponseDto matriculaResponseDto = matriculaService.show(id);
        return ResponseEntity.ok(matriculaResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
