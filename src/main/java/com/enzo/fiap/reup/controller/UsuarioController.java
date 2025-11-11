package com.enzo.fiap.reup.controller;

import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import com.enzo.fiap.reup.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid  @RequestBody UsuarioRequestDto body){
        UsuarioResponseDto userResponseDto = usuarioService.create(body);

        URI uri = URI.create("/usuarios/" + userResponseDto.id());

        return ResponseEntity.created(uri).body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> index(){
        List<UsuarioResponseDto> usersResponseDto = usuarioService.index();
        return ResponseEntity.ok(usersResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> show(@PathVariable Long id){
        UsuarioResponseDto userResponseDto = usuarioService.show(id);
        return ResponseEntity.ok(userResponseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UsuarioRequestDto body){
        usuarioService.update(id, body);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
