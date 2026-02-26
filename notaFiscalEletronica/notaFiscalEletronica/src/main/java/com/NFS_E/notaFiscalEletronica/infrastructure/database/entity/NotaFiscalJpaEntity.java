package com.NFS_E.notaFiscalEletronica.infrastructure.database.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.NFS_E.notaFiscalEletronica.domain.entity.ItemNotaFiscal;
import com.NFS_E.notaFiscalEletronica.domain.entity.enums.StatusNota;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "notas_fiscais")
@Data
public class NotaFiscalJpaEntity {
    
    @Id
    private UUID id;

    @Column(name="documento_destino", nullable=false)
    private String docDestino;

    @Column(name="valor_total", nullable=false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name="nf_status", nullable=false)
    private StatusNota status;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name= "nota_fiscal_id")
    private List<ItemNotaFiscal> itens;
}
