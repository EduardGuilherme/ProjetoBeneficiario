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
    public ResponseEntity<String> createBeneficiario(@RequestBody BeneficiarioDTO beneficiarioDTO){
        //BeneficiarioModel createdBeneficiario =
                beneficiarioService.saveBeneficiarioDocumento(beneficiarioDTO);
        return new ResponseEntity<>("Beneficiario e Documentos Criados com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBeneficiario(@PathVariable UUID id, @RequestBody BeneficiarioDTO beneficiarioDTO){
        //BeneficiarioModel beneficiarioUpdate =
                beneficiarioService.updateBeneficiario(id, beneficiarioDTO);
        return new ResponseEntity<>("Beneficiario foi atualizado!",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> beneficiarioDelete(@PathVariable UUID id){
            beneficiarioService.deleteBeneficiario(id);
            return new ResponseEntity<>("Beneficiario e documento foram deletados",HttpStatus.OK);

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
