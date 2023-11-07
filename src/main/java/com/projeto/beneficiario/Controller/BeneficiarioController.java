package com.projeto.beneficiario.Controller;

import com.projeto.beneficiario.DTO.BeneficiarioDTO;
import com.projeto.beneficiario.Models.BeneficiarioModel;
import com.projeto.beneficiario.Models.DocumentoModel;
import com.projeto.beneficiario.Services.BeneficiarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioModel> createBeneficiario(@RequestBody BeneficiarioDTO beneficiarioDTO){
        BeneficiarioModel beneficiarioModel = new BeneficiarioModel();
        beneficiarioModel.setNome(beneficiarioDTO.nome());
        beneficiarioModel.setTelefone(beneficiarioDTO.telefone());
        beneficiarioModel.setDataNascimento(beneficiarioDTO.dataNascimento());

        List<DocumentoModel> documentos = beneficiarioDTO.documentos();

        BeneficiarioModel savedBeneficiario = beneficiarioService.saveBeneficiarioDocumento(beneficiarioModel, documentos);

        return new ResponseEntity<>(savedBeneficiario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioModel> updateBeneficiario(@PathVariable UUID id, @RequestBody BeneficiarioDTO beneficiarioDTO){
        BeneficiarioModel beneficiarioUpdate = beneficiarioService.updateBeneficiario(id, beneficiarioDTO);
        return new ResponseEntity<>(beneficiarioUpdate,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> beneficiarioDelete(@PathVariable UUID id){
        beneficiarioService.deleteBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<Page<BeneficiarioModel>> listBeneficiario(Pageable pageable){
        Page<BeneficiarioModel> beneficiarios = beneficiarioService.findAllBeneficiario(pageable);
        return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<DocumentoModel>> listDocumentoBeneficiario(@PathVariable UUID id){
        List<DocumentoModel>documentos = beneficiarioService.findDocumentosandBeneficiario(id);
        return new ResponseEntity<>(documentos,HttpStatus.OK);
    }

}
