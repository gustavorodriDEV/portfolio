package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.entities.PerfilApresentacao;
import com.gustavo.portfolio.backend.service.PerfilApresentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/perfil")
@CrossOrigin(origins = "*")
public class PerfilApresentacaoController {

    @Autowired
    private PerfilApresentacaoService perfilService;

    @PostMapping
    public ResponseEntity<PerfilApresentacao> criar(@RequestBody @Valid PerfilApresentacao perfil) {
        PerfilApresentacao novo = perfilService.adicionar(
                perfil.getNome(),
                perfil.getCargo(),
                perfil.getDescricao(),
                perfil.getFotoUrl()
        );
        return ResponseEntity.ok(novo);
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
