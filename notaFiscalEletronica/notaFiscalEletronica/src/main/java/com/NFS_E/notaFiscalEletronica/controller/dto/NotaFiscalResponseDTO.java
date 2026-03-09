package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;

public record NotaFiscalResponseDTO(

        UUID id,
        String notaFiscalDestino
        BigDecimal valorTotal,
        String status,
        List<ItemNotaFiscalResponseDTO> itens
) {
    
}
