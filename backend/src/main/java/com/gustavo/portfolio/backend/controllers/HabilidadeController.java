package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.entities.Habilidade;
import com.gustavo.portfolio.backend.service.HabilidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
@CrossOrigin(origins = "*")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @PostMapping
    public ResponseEntity<Habilidade> salvar(@RequestBody @Valid Habilidade habilidade) {
        return ResponseEntity.ok(habilidadeService.salvar(habilidade));
    }

    @GetMapping
    public ResponseEntity<List<Habilidade>> listar() {
        return ResponseEntity.ok(habilidadeService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        habilidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
