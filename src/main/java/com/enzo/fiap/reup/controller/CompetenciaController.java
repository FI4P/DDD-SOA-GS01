package com.enzo.fiap.reup.controller;

import com.enzo.fiap.reup.dto.competencia.CompetenciaRequestDto;
import com.enzo.fiap.reup.dto.competencia.CompetenciaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import com.enzo.fiap.reup.service.CompetenciaService;
import com.enzo.fiap.reup.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {


    private final CompetenciaService competenciaService;

    public CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService;
    }

    @PostMapping
    public ResponseEntity<CompetenciaResponseDto> create(@Valid  @RequestBody CompetenciaRequestDto body){
        CompetenciaResponseDto competenciaResponseDto = competenciaService.create(body);

        URI uri = URI.create("/competencias/" + competenciaResponseDto.id());

        return ResponseEntity.created(uri).body(competenciaResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaResponseDto>> index(){
        List<CompetenciaResponseDto> competenciaResponseDtos = competenciaService.index();
        return ResponseEntity.ok(competenciaResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaResponseDto> show(@PathVariable Long id){
        CompetenciaResponseDto competenciaResponseDto = competenciaService.show(id);
        return ResponseEntity.ok(competenciaResponseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CompetenciaRequestDto body){
        competenciaService.update(id, body);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        competenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
