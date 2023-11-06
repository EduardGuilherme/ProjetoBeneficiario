package com.projeto.beneficiario.DTO;

import com.projeto.beneficiario.Models.BeneficiarioModel;

import java.util.Date;

public record BeneficiarioDTO(String nome,
                              String telefone,
                              Date dataNascimento,
                              Date dataInclusao,
                              Date dataAtualizacao) {

    public BeneficiarioDTO(BeneficiarioModel beneficiarioModel){
        this(beneficiarioModel.getNome(),beneficiarioModel.getTelefone(),beneficiarioModel.getDataNascimento(),beneficiarioModel.getDataInclusao(),beneficiarioModel.getDataAtualizacao());
    }
}
