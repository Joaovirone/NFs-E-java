package com.NFS_E.notaFiscalEletronica.application.usecase;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NFS_E.notaFiscalEletronica.domain.entity.ItemNotaFiscal;
import com.NFS_E.notaFiscalEletronica.domain.entity.NotaFiscal;
import com.NFS_E.notaFiscalEletronica.domain.repository.NotaFiscalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmitirNotaFiscalUseCase {
    
    private final NotaFiscalRepository repository;

    @Transactional
    public NotaFiscal executar(String docDestino, List<ItemInput> itensInput){


        NotaFiscal nota = new NotaFiscal(docDestino);

        itensInput.forEach(input -> {
                
                ItemNotaFiscal item = new ItemNotaFiscal(
                    input.descricao(),
                    input.valorUnitario(),
                    input.quantidade()

                );
                nota.adicionarItem(item);

                
        });

        repository.salvar(nota);

        return nota;
    }

    public record ItemInput(
        String descricao,
        BigDecimal valorUnitario,
        BigDecimal quantidade
    ){}
}
