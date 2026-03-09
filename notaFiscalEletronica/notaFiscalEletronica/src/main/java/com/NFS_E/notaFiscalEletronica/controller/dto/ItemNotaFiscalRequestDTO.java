package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemNotaFiscalRequestDTO{
   

        String descricao;
        BigDecimal quantidade;
        BigDecimal valorUnitari;
}
