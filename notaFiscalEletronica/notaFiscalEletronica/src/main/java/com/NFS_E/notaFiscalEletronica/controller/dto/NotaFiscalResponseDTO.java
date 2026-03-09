package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalResponseDTO {
    private UUID id;
    private String notaFiscalDestino;
    private BigDecimal valorTotal;
    private String status;
    private List<ItemNotaFiscalResponseDTO> itens;
}
