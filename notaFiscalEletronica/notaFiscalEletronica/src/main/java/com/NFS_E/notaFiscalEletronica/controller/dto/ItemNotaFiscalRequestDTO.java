package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemNotaFiscalRequestDTO{
   
        @NotBlank(message="Descrição do Item é obrigatória")
        private String descricao;

        @Positive(message="A quantidade deve ser maior que zero")
        private BigDecimal quantidade;

        @Positive(message="O valor unitário deve ser positivo")
        private BigDecimal valorUnitario;

        private String ncm;         
        private String cfop;         
        private String cstIcms;      
        private BigDecimal aliquotaIcms; 
}
