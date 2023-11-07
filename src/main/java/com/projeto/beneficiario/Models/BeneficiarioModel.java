package com.projeto.beneficiario.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "beneficiario")
public class BeneficiarioModel implements Serializable {
    private static final long SerialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID beneficiarioId;
    private String nome;
    private String telefone;
    private Date dataNascimento;

    private  Date dataInclusao;
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "beneficiarioModel", cascade = CascadeType.ALL)
    private List<DocumentoModel> documentos;

    public BeneficiarioModel() {
    }

    public BeneficiarioModel(UUID beneficiarioId, String nome, String telefone, Date dataNascimento, Date dataInclusao, Date dataAtualizacao, List<DocumentoModel> documentos) {
        this.beneficiarioId = beneficiarioId;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.documentos = documentos;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<DocumentoModel> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoModel> documentos) {
        this.documentos = documentos;
    }
}
