package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.dto.PerfilDTO;
import com.gustavo.portfolio.backend.entities.PerfilApresentacao;
import com.gustavo.portfolio.backend.service.PerfilApresentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
@RequestMapping("/api/perfil")
public class PerfilApresentacaoController {

    @Autowired
    private PerfilApresentacaoService perfilService;

    @PostMapping
    public ResponseEntity<PerfilApresentacao> criar(@RequestBody @Valid PerfilDTO perfil) {
        try {
            PerfilApresentacao novo = perfilService.adicionar(
                    perfil.getNome(),
                    perfil.getCargo(),
                    perfil.getDescricao(),
                    perfil.getFotoUrl()
            );
            return ResponseEntity.ok(novo);
        } catch (Exception e) {
            e.printStackTrace(); // <- isso mostra o erro REAL no console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping
    public ResponseEntity<List<PerfilApresentacao>> listarTodos() {
        return ResponseEntity.ok(perfilService.listar());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PerfilApresentacao> atualizarParcial(
            @PathVariable Long id,
            @RequestBody PerfilApresentacao dadosAtualizados) {

        PerfilApresentacao atualizado = perfilService.atualizar(
                id,
                dadosAtualizados.getNome(),
                dadosAtualizados.getCargo(),
                dadosAtualizados.getDescricao(),
                dadosAtualizados.getFotoUrl()
        );
        return ResponseEntity.ok(atualizado);
    }

}
