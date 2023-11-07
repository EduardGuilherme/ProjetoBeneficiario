package com.projeto.beneficiario.Services;

import com.projeto.beneficiario.DTO.BeneficiarioDTO;
import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Repository.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class BeneficiarioService {
    final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @Transactional
    public BeneficiarioModel saveBeneficiario(BeneficiarioModel beneficiarioModel){
        beneficiarioModel.setDataInclusao(new Date());
        return beneficiarioRepository.save(beneficiarioModel);
    }

    public BeneficiarioModel updateBeneficiario(UUID id, BeneficiarioDTO beneficiarioDTO){
        Optional<BeneficiarioModel> beneficiarioExist = beneficiarioRepository.findById(id);
        if(beneficiarioExist.isPresent()){
            BeneficiarioModel existbeneficiario = beneficiarioExist.get();
            existbeneficiario.setNome(beneficiarioDTO.nome());
            existbeneficiario.setDataNascimento(beneficiarioDTO.dataNascimento());
            existbeneficiario.setTelefone(beneficiarioDTO.telefone());
            existbeneficiario.setDataAtualizacao(new Date());

            return beneficiarioRepository.save(existbeneficiario);
        }else{
            throw new IllegalArgumentException("Beneficiario não encontrado");
        }
    }

    public void deleteBeneficiario(BeneficiarioModel beneficiarioModel){
        beneficiarioRepository.delete(beneficiarioModel);
    }

    public Page<BeneficiarioModel> findAllBeneficiario(Pageable pageable){
        return beneficiarioRepository.findAll(pageable);
    }

    public Optional<BeneficiarioModel> findByBeneficiarioId(UUID id){
        return beneficiarioRepository.findById(id);
    }
}
