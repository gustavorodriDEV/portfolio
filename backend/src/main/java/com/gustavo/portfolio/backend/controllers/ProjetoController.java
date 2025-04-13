package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.entities.Projeto;
import com.gustavo.portfolio.backend.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
@CrossOrigin(origins = "*")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/teste")
    public String teste(){
        return "Backend está rodando perfeitamente!";
    }

    @PostMapping
    public ResponseEntity<Projeto> salvarProjeto(@Valid @RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.salvar(projeto));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listaProjetos(){
        return ResponseEntity.ok(projetoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable Long id, @RequestBody Projeto novosDados) {
        Projeto atualizado = projetoService.atualizar(id, novosDados);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}/limpar-link")
    public ResponseEntity<Projeto> limparLinkEspecifico(@PathVariable Long id, @RequestParam String tipo) {
        Projeto atualizado = projetoService.limparLiks(id, tipo);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjetos(@PathVariable Long id){
        projetoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
