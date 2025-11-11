package com.enzo.fiap.reup.infrastructure.exceptions;


import com.enzo.fiap.reup.dto.error.ErrorResponseDto;
import com.enzo.fiap.reup.dto.error.FieldErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){

        List<FieldErrorResponseDto> fieldErrorResponseDtos = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> FieldErrorResponseDto.builder().field(fieldError.getField()).message(fieldError.getDefaultMessage()).build()).toList();
        ErrorResponseDto error = ErrorResponseDto.builder().status(400).fieldErrors(fieldErrorResponseDtos).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<ErrorResponseDto> duplicatedUserExceptionHandler(DuplicatedUserException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(409).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> userNotFoundExceptionHandler(UserNotFoundException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(404).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(TrilhaNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> trilhaNotFoundExcpetionHandle(TrilhaNotFoundException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(404).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DuplicatedCompetenciaException.class)
    public ResponseEntity<ErrorResponseDto> duplicatedCompetenciaExceptionHandler(DuplicatedCompetenciaException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(409).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(CompetenciaNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> competenciaNotFoundExceptionHandler(CompetenciaNotFoundException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(404).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MatriculaNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> matriculaNotFoundExceptionHandler(MatriculaNotFoundException ex){
        ErrorResponseDto error = ErrorResponseDto.builder().status(404).messsage(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }








}
