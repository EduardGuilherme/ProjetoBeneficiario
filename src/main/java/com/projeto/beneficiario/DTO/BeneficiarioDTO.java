package com.projeto.beneficiario.DTO;

import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;

import java.util.Date;
import java.util.List;

public record BeneficiarioDTO(String nome,
                              String telefone,
                              Date dataNascimento,
                              Date dataInclusao,
                              Date dataAtualizacao,
                              List<DocumentoModel> documentos) {

    public BeneficiarioDTO(BeneficiarioModel beneficiarioModel){
        this(beneficiarioModel.getNome(),beneficiarioModel.getTelefone(),beneficiarioModel.getDataNascimento(),beneficiarioModel.getDataInclusao(),beneficiarioModel.getDataAtualizacao(),beneficiarioModel.getDocumentos());
    }
}
