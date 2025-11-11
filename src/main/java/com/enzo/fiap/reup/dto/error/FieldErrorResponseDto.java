package com.enzo.fiap.reup.dto.error;


import lombok.Builder;

@Builder
public record FieldErrorResponseDto (
        String field,
        String message
){

}
