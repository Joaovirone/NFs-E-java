package com.NFS_E.notaFiscalEletronica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.NFS_E.notaFiscalEletronica.controller.dto.NotaFiscalRequestDTO;
import com.NFS_E.notaFiscalEletronica.controller.dto.NotaFiscalResponseDTO;
import com.NFS_E.notaFiscalEletronica.controller.dto.mapper.NotaFiscalMapper;
import com.NFS_E.notaFiscalEletronica.entity.NotaFiscal;
import com.NFS_E.notaFiscalEletronica.entity.enums.StatusNota;
import com.NFS_E.notaFiscalEletronica.repository.NotaFiscalRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    
    private final NotaFiscalRepository repository;
    private final NotaFiscalMapper mapper;


    @Transactional
    public NotaFiscalResponseDTO emitir( NotaFiscalRequestDTO dto){

        NotaFiscal nota = mapper.toEntity(dto);

        if(nota.getItens() != null ){
            nota.getItens().forEach(item -> item.setNotaFiscal(nota));
        }

        nota.setStatus(StatusNota.PROCESSANDO);
        nota.calcularTotal();

        NotaFiscal notaSalva = repository.save(nota);

        return mapper.toResponse(notaSalva);


    }

    public List<NotaFiscalResponseDTO> listarTodas(){

        return repository.findAll().stream().map(mapper :: toResponse).toList();
    }

    
}
