package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.entities.Contato;
import com.gustavo.portfolio.backend.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin(origins ="*")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> adicionarContato(@RequestBody @Valid Contato contato){
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.adicionarContato(contato));
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContato(){
       List<Contato> contatos = contatoService.listaContato();
       return ResponseEntity.ok(contatos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id){
       contatoService.excluirContato(id);
       return ResponseEntity.noContent().build();
    }
}
