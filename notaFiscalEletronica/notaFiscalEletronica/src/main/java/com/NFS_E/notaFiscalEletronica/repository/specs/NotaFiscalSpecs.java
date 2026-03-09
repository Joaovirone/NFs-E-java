package com.NFS_E.notaFiscalEletronica.repository.specs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.NFS_E.notaFiscalEletronica.controller.dto.NotaFiscalFiltroDTO;
import com.NFS_E.notaFiscalEletronica.entity.NotaFiscal;

import jakarta.persistence.criteria.Predicate;

public class NotaFiscalSpecs {
    
    public static Specification<NotaFiscal> comFiltros(NotaFiscalFiltroDTO filtro){

        return(root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if(filtro.getNotaFiscalDestino() != null && !filtro.getNotaFiscalDestino().isBlank()){

                predicates.add(builder.like(
                    builder.lower(root.get("notaFiscalDestino")),
                    "%" + filtro.getNotaFiscalDestino().toLowerCase() + "%"
                ));
            }

            if(filtro.getStatus() != null){
                predicates.add(builder.equal(root.get("status"), filtro.getStatus()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
       
        };
    }
}
