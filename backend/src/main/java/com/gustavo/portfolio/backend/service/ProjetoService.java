package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.Projeto;
import com.gustavo.portfolio.backend.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvar(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listar(){
        return projetoRepository.findAll();
    }

    public void excluir(Long id){
        projetoRepository.deleteById(id);
    }
}
