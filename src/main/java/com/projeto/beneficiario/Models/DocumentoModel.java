package com.projeto.beneficiario.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "documento")
public class DocumentoModel implements Serializable {
    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID documentoId;
    private String tipoDocumento;
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dataInclusao;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dataAtualizacao;

    @ManyToOne
    private BeneficiarioModel beneficiarioModel;

    public DocumentoModel() {
    }

    public DocumentoModel(UUID documentoId, String tipoDocumento, String descricao, BeneficiarioModel beneficiarioModel) {
        this.documentoId = documentoId;
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.beneficiarioModel = beneficiarioModel;
    }
    @PrePersist
    protected void onCreate() {
        dataInclusao = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDate.now();
    }
    public UUID getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(UUID documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public BeneficiarioModel getbeneficiariomodel(){
        return  beneficiarioModel;
    }
    public void setbeneficiariomodel(BeneficiarioModel beneficiarioModel){
        this.beneficiarioModel = beneficiarioModel;
    }
}
