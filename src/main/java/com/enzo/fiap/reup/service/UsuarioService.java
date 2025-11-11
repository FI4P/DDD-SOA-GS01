package com.enzo.fiap.reup.service;


import com.enzo.fiap.reup.domain.usuario.Usuario;
import com.enzo.fiap.reup.dto.usuario.UsuarioRequestDto;
import com.enzo.fiap.reup.dto.usuario.UsuarioResponseDto;
import com.enzo.fiap.reup.infrastructure.exceptions.DuplicatedUserException;
import com.enzo.fiap.reup.infrastructure.exceptions.UserNotFoundException;
import com.enzo.fiap.reup.mapper.UsuarioMapper;
import com.enzo.fiap.reup.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private  final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }


    public UsuarioResponseDto create(UsuarioRequestDto dto){
        Optional<Usuario> duplicatedUser = usuarioRepository.findByEmail(dto.email());

        duplicatedUser.ifPresent(user -> {
            throw  new DuplicatedUserException();
        });

        Usuario user = usuarioMapper.toEntity(dto);

        usuarioRepository.save(user);

        return usuarioMapper.toResponse(user, false);
    }

    public List<UsuarioResponseDto> index(){

        List<Usuario> user = usuarioRepository.findAll();

        List<UsuarioResponseDto> usersResponseDto = user.stream().map(u -> usuarioMapper.toResponse(u, false)).toList();

        return usersResponseDto;
    }

    public UsuarioResponseDto show(Long id){

        Usuario user = usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return usuarioMapper.toResponse(user, false);
    }


    public void update(Long id, UsuarioRequestDto dto){

        Usuario user =  usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setName(dto.nome() != null ? dto.nome() : user.getName());
        user.setEmail(dto.email() != null ? dto.email() : user.getEmail());
        user.setAreaAtuacao(dto.areaAtuacao() != null ? dto.areaAtuacao() : user.getAreaAtuacao());
        user.setNivelCarreira(dto.nivelCarreira() != null ? dto.nivelCarreira() : user.getNivelCarreira());

        usuarioRepository.save(user);

    }

    public void delete(Long id){

        Usuario user = usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new);

        usuarioRepository.delete(user);

    }





}
