package com.projeto.beneficiario.Repository;

import com.projeto.beneficiario.Models.DocumentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<DocumentoModel, UUID> {
    List<DocumentoModel> findByBeneficiarioModel_BeneficiarioId(UUID id);
}
