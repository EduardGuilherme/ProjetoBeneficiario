package com.projeto.beneficiario.Services;

import com.projeto.beneficiario.DTO.BeneficiarioDTO;
import com.projeto.beneficiario.DTO.DocumentoDTO;
import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;
import com.projeto.beneficiario.Repository.BeneficiarioRepository;
import com.projeto.beneficiario.Repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BeneficiarioService {
    final BeneficiarioRepository beneficiarioRepository;
    final DocumentoRepository documentoRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository, DocumentoRepository documentoRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
        this.documentoRepository = documentoRepository;
    }

    @Transactional
    public BeneficiarioModel saveBeneficiarioDocumento(BeneficiarioDTO beneficiarioDTO){
        BeneficiarioModel beneficiarioModel = new BeneficiarioModel();
        beneficiarioModel.setNome(beneficiarioDTO.getNome());
        beneficiarioModel.setTelefone(beneficiarioDTO.getTelefone());
        beneficiarioModel.setDataNascimento(beneficiarioDTO.getDataNascimento());

        List<DocumentoModel> documentos = new ArrayList<>();
        for (DocumentoDTO documentoDTO : beneficiarioDTO.getDocumentos()) {
            DocumentoModel documentoModel = new DocumentoModel();
            documentoModel.setTipoDocumento(documentoDTO.getTipoDocumento());
            documentoModel.setDescricao(documentoDTO.getDescricao());
            documentoModel.setbeneficiariomodel(beneficiarioModel);
            documentos.add(documentoModel);
        }

        beneficiarioModel.setDocumentos(documentos);

        return beneficiarioRepository.save(beneficiarioModel);
    }

    public BeneficiarioModel updateBeneficiario(UUID id, BeneficiarioDTO beneficiarioDTO){
        Optional<BeneficiarioModel> beneficiarioExist = beneficiarioRepository.findById(id);
        if(beneficiarioExist.isPresent()){
            BeneficiarioModel existbeneficiario = beneficiarioExist.get();
            existbeneficiario.setNome(beneficiarioDTO.getNome());
            existbeneficiario.setDataNascimento(beneficiarioDTO.getDataNascimento());
            existbeneficiario.setTelefone(beneficiarioDTO.getTelefone());

            return beneficiarioRepository.save(existbeneficiario);
        }else{
            throw new IllegalArgumentException("Beneficiario não encontrado");
        }
    }

    public void deleteBeneficiario(UUID id){
        beneficiarioRepository.deleteById(id);
    }

    public Page<BeneficiarioModel> findAllBeneficiario(Pageable pageable){
        return beneficiarioRepository.findAll(pageable);
    }
    public List<DocumentoModel> findDocumentosandBeneficiario(UUID beneficiarioId) {
        return documentoRepository.findByBeneficiarioModel_BeneficiarioId(beneficiarioId);
    }
}
