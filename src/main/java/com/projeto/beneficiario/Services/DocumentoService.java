package com.projeto.beneficiario.Services;

import com.projeto.beneficiario.DTO.DocumentoDTO;
import com.projeto.beneficiario.Models.DocumentoModel;
import com.projeto.beneficiario.Repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
@Service
public class DocumentoService {
    final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }
    @Transactional
    public DocumentoModel saveDocumento(DocumentoModel documentoModel){
        documentoModel.setDataInclusao(new Date());
        return documentoRepository.save(documentoModel);
    }

    public DocumentoModel updateDocumento(UUID id, DocumentoDTO documentoDTO){
        Optional<DocumentoModel> documentoExist = documentoRepository.findById(id);
        if(documentoExist.isPresent()){
            DocumentoModel existDoc = documentoExist.get();
            existDoc.setTipoDocumento(documentoDTO.tipoDocumento());
            existDoc.setDescricao(documentoDTO.descricao());
            existDoc.setDataAtualizacao(new Date());

            return documentoRepository.save(existDoc);
        }else{
            throw new IllegalArgumentException("Documento Não encontrado!");
        }
    }
    public void deleteDocumento(DocumentoModel documentoModel){
        documentoRepository.delete(documentoModel);
    }
    public Page<DocumentoModel> findallDocumentos(Pageable pageable){
        return documentoRepository.findAll(pageable);
    }

    public Optional<DocumentoModel> findbyDocumentoId(UUID id){
        return documentoRepository.findById(id);
    }
}
