package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalRequestDTO{

    @NotBlank(message = "O destino da nota é obrigatório")
    @Size(min = 3, max = 255, message = "O nome do destino deve ter entre 3 e 255 caracteres")
    private String notaFiscalDestino;

    @NotEmpty(message = "A nota fiscal deve conter pelo menos um item")
    @Valid 
    private List<ItemNotaFiscalRequestDTO> itens;
}
