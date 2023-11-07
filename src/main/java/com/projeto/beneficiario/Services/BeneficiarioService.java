package com.projeto.beneficiario.Services;

import com.projeto.beneficiario.DTO.BeneficiarioDTO;
import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;
import com.projeto.beneficiario.Repository.BeneficiarioRepository;
import com.projeto.beneficiario.Repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
    public BeneficiarioModel saveBeneficiarioDocumento(BeneficiarioModel beneficiarioModel, List<DocumentoModel> documentos){
        beneficiarioModel.setDocumentos(documentos);
        BeneficiarioModel saveBeneficiario = beneficiarioRepository.save(beneficiarioModel);

        documentos.forEach(documento -> documento.setbeneficiariomodel(saveBeneficiario));
        documentoRepository.saveAll(documentos);

        return saveBeneficiario;
    }

    public BeneficiarioModel updateBeneficiario(UUID id, BeneficiarioDTO beneficiarioDTO){
        Optional<BeneficiarioModel> beneficiarioExist = beneficiarioRepository.findById(id);
        if(beneficiarioExist.isPresent()){
            BeneficiarioModel existbeneficiario = beneficiarioExist.get();
            existbeneficiario.setNome(beneficiarioDTO.nome());
            existbeneficiario.setDataNascimento(beneficiarioDTO.dataNascimento());
            existbeneficiario.setTelefone(beneficiarioDTO.telefone());

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
    /*public Optional<BeneficiarioModel> findByBeneficiarioId(UUID id){
        return beneficiarioRepository.findById(id);
    }*/
}
