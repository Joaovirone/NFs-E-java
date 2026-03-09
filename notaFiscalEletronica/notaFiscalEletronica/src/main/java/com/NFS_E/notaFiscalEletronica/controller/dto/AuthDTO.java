package com.NFS_E.notaFiscalEletronica.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthDTO {
    
    
    @NotBlank(message="Login não pode ser nulo")
    private String login;
    
    @NotBlank(message="Senha não pode ser nula")
    private String senha;
}
