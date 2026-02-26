package com.NFS_E.notaFiscalEletronica.domain.entity;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ItemNotaFiscal {
    
    private final String descricao;
    private final BigDecimal valorUnitario;
    private final BigDecimal quantidade;
    private final BigDecimal valorTotal;

    public ItemNotaFiscal(String descricao, BigDecimal valorUnitario, BigDecimal quantidade, BigDecimal valorTotal){

        this.descricao = descricao;
        this. valorUnitario = valorUnitario;
        this.quantidade = quantidade;

        this.valorTotal = valorUnitario.multiply(quantidade);
    }
}
