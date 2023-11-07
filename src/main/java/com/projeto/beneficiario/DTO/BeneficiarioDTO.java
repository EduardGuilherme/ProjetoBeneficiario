package com.projeto.beneficiario.DTO;

import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record BeneficiarioDTO(String nome,
                              String telefone,
                              LocalDate dataNascimento,
                              LocalDate dataInclusao,
                              LocalDate dataAtualizacao,
                              List<DocumentoModel> documentos) {

    public BeneficiarioDTO(BeneficiarioModel beneficiarioModel){
        this(beneficiarioModel.getNome(),beneficiarioModel.getTelefone(),beneficiarioModel.getDataNascimento(),beneficiarioModel.getDataInclusao(),beneficiarioModel.getDataAtualizacao(),beneficiarioModel.getDocumentos());
    }
}
