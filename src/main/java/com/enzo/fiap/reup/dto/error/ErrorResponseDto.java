package com.enzo.fiap.reup.dto.error;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record ErrorResponseDto(
        int status,
        String messsage,
        LocalDateTime timestamp,
        List<FieldErrorResponseDto> fieldErrors
) {

}
