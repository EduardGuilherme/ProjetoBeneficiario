package com.projeto.beneficiario.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "beneficiario")
public class BeneficiarioModel implements Serializable {
    private static final long SerialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID beneficiarioId;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dataInclusao;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiarioModel", cascade = CascadeType.ALL)
    private List<DocumentoModel> documentos;

    public BeneficiarioModel() {
    }

    public BeneficiarioModel(UUID beneficiarioId, String nome, String telefone, LocalDate dataNascimento, List<DocumentoModel> documentos) {
        this.beneficiarioId = beneficiarioId;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.documentos = documentos;
    }
    @PrePersist
    protected void onCreate() {
        dataInclusao = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDate.now();
    }
    public UUID getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(UUID beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<DocumentoModel> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoModel> documentos) {
        this.documentos = documentos;
    }
}
