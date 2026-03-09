package com.NFS_E.notaFiscalEletronica.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalRequestDTO{
    String notaFsicalDestino;
    List<ItemNotaFiscalRequestDTO> itens;
}
