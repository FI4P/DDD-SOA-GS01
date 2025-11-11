package com.enzo.fiap.reup.controller;

import com.enzo.fiap.reup.dto.trilha.TrilhaRequestDto;
import com.enzo.fiap.reup.dto.trilha.TrilhaResponseDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;

import com.enzo.fiap.reup.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    public final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @PostMapping
    public ResponseEntity<TrilhaResponseDto> create(@Valid  @RequestBody TrilhaRequestDto body){
        TrilhaResponseDto trilhaResponseDto = trilhaService.create(body);

        URI uri = URI.create("/trilhas/" + trilhaResponseDto.id());
        return ResponseEntity.created(uri).body(trilhaResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<TrilhaResponseDto>> index(){
        List<TrilhaResponseDto> trilhasResponseDtos = trilhaService.index();
        return ResponseEntity.ok(trilhasResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponseDto> show(@PathVariable Long id){
        TrilhaResponseDto trilhaResponseDto = trilhaService.show(id);
        return ResponseEntity.ok(trilhaResponseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TrilhaRequestDto body){
        trilhaService.update(id, body);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        trilhaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
