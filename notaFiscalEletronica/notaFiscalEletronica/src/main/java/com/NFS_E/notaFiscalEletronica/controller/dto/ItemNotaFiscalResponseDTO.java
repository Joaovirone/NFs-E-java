package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemNotaFiscalResponseDTO{
    UUID id;
    String descricao;
    BigDecimal quantidade;
    BigDecimal valorUnitario;
    BigDecimal valorTotal;

}
