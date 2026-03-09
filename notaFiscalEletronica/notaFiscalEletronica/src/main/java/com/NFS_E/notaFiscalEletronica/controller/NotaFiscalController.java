package com.NFS_E.notaFiscalEletronica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NFS_E.notaFiscalEletronica.entity.NotaFiscal;
import com.NFS_E.notaFiscalEletronica.service.NotaFiscalService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.NFS_E.notaFiscalEletronica.controller.dto.NotaFiscalRequestDTO;
import com.NFS_E.notaFiscalEletronica.controller.dto.NotaFiscalResponseDTO;
import com.NFS_E.notaFiscalEletronica.entity.ItemNotaFiscal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/notas-fiscais")
@RequiredArgsConstructor
public class NotaFiscalController {
    
    private final NotaFiscalService service;


    @PostMapping
    public ResponseEntity<NotaFiscalResponseDTO> criarNota(@RequestBody NotaFiscalRequestDTO request) {

        NotaFiscalResponseDTO response = service.emitir(request);

        return ResponseEntity.ok(response);
    
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscalResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
    

}