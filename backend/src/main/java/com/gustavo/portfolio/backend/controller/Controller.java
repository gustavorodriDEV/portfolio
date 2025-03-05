package com.gustavo.portfolio.backend.controller;

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
public class Controller {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/teste")
    public String teste(){
        return "Backend está rodando perfeitamente!";
    }

    @PostMapping
    public ResponseEntity<Projeto> salvarProjeto(@Valid @RequestBody Projeto projeto) {
        System.out.println("JSON Recebido: " + projeto);
        System.out.println("Descrição recebida: " + projeto.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.salvar(projeto));
    }



    @GetMapping
    public ResponseEntity<List<Projeto>> listaProjetos(){
        List<Projeto> projetos = projetoService.listar();
        return ResponseEntity.ok(projetos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjetos(@PathVariable Long id){
        projetoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
