package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.Contato;
import com.gustavo.portfolio.backend.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
   private ContatoRepository contatoRepository;

    public Contato adicionarContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public List<Contato> listaContato(){
        return contatoRepository.findAll();
    }

    public void excluirContato(Long id){
        contatoRepository.deleteById(id);
    }
}

