package com.projeto.beneficiario.Repository;

import com.projeto.beneficiario.Models.BeneficiarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioModel, UUID> {
}
