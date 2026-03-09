package com.NFS_E.notaFiscalEletronica.controller.dto;

import com.NFS_E.notaFiscalEletronica.entity.enums.StatusNota;

import lombok.Data;

@Data
public class NotaFiscalFiltroDTO {
    private String notaFiscalDestino;
    private StatusNota status;

}
