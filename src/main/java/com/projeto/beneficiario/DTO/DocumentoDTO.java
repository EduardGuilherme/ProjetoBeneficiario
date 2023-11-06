package com.projeto.beneficiario.DTO;

import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;

import java.util.Date;

public record DocumentoDTO(String tipoDocumento,
                           String descricao,
                           Date dataInclusao,
                           Date dataAtualizacao,
                           BeneficiarioModel beneficiarioModel) {

    public DocumentoDTO(DocumentoModel documentoModel){
        this(documentoModel.getTipoDocumento(),documentoModel.getDescricao(),documentoModel.getDataInclusao(),documentoModel.getDataAtualizacao(),documentoModel.getbeneficiariomodel());
    }
}
