package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.util.List;

public record NotaFiscalRequestDTO(

    String notaFsicalDestino,
    List<ItemNotaFiscalRequestDTO> itens

) {
    
}
