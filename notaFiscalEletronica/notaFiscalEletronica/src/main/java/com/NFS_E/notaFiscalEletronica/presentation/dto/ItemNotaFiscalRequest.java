package com.NFS_E.notaFiscalEletronica.presentation.dto;

import java.math.BigDecimal;

public record ItemNotaFiscalRequest(
    String descricao,
    BigDecimal quantidade,
    BigDecimal valorUnitario
) {}
