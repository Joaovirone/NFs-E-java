package com.NFS_E.notaFiscalEletronica.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.NFS_E.notaFiscalEletronica.domain.entity.NotaFiscal;

public interface NotaFiscalRepository {
    
    void salvar(NotaFiscal nota);

    Optional<NotaFiscal> buscarPorId(UUID id);
}
