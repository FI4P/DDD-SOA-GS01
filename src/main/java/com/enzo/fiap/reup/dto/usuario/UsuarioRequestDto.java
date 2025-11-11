package com.enzo.fiap.reup.dto.usuario;

import com.enzo.fiap.reup.domain.usuario.NivelCarreira;
import com.enzo.fiap.reup.domain.usuario.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto (

        @NotBlank(message = "O nome de usuário precisa ser digitado!")
        String nome,

        @Email(message = "E-mail inválido!")
        String email,


        NivelCarreira nivelCarreira,

        @NotBlank(message = "Digite a área em que o profissional atua!")
        String areaAtuacao,

        UserRoles roles

){

}
