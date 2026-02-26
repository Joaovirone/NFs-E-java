package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public record NotaFiscalRequest(String notaFiscalDestino, List<ItemRequest> itens) {
    
    public record ItemRequest(String descricao, BigDecimal quantidade, BigDecimal valorUnitario)
    
    
    {}
}
