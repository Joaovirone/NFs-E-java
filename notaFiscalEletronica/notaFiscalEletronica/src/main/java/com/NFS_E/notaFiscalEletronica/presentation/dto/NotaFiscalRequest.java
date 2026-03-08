package com.NFS_E.notaFiscalEletronica.presentation.dto;

import java.util.List;

public record NotaFiscalRequest(
    String notaFiscalDestino,
    List<ItemNotaFiscalRequest> itens
) {}
