package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.Habilidade;
import com.gustavo.portfolio.backend.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public Habilidade salvar(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public List<Habilidade> listar() {
        return habilidadeRepository.findAll();
    }

    public void excluir(Long id) {
        habilidadeRepository.deleteById(id);
    }
}
