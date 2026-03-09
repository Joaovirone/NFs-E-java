package com.NFS_E.notaFiscalEletronica.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

public class ExceptionHandlerController {
    
        @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex){

        var erros = ex.getFieldErrors().stream()
            .map(err -> new DadosErroValidacao(err.getField(), err.getDefaultMessage()))
            .toList();

            return ResponseEntity.badRequest().body(erros);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handle404(){

        return ResponseEntity.notFound().build();

    }
    
    private record DadosErroValidacao(String campo, String mensagem){}
}

    


