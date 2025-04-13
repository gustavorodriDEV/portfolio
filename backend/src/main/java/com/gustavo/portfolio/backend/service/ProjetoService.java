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

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID " + id));
    }

    public Projeto atualizar(Long id, Projeto novosDados) {
        Projeto projeto = buscarPorId(id);

        if (novosDados.getTitulo() != null && !novosDados.getTitulo().isBlank()) {
            projeto.setTitulo(novosDados.getTitulo());
        }
        if (novosDados.getDescricao() != null && !novosDados.getDescricao().isBlank()) {
            projeto.setDescricao(novosDados.getDescricao());
        }
        if (novosDados.getLinkGithub() != null && !novosDados.getLinkGithub().isBlank()) {
            projeto.setLinkGithub(novosDados.getLinkGithub());
        }
        if (novosDados.getLinkHospedado() != null && !novosDados.getLinkHospedado().isBlank()) {
            projeto.setLinkHospedado(novosDados.getLinkHospedado());
        }
        if (novosDados.getImagemUrl() != null && !novosDados.getImagemUrl().isBlank()) {
            projeto.setImagemUrl(novosDados.getImagemUrl());
        }

        return projetoRepository.save(projeto);
    }

    public Projeto limparLiks(Long id, String tipo){
        Projeto projeto = buscarPorId(id);

        if("github".equalsIgnoreCase(tipo)){
            projeto.setLinkGithub(null);
        } else if ("hospedado".equalsIgnoreCase(tipo)) {
            projeto.setLinkHospedado("");
        } else {
            throw new IllegalArgumentException("Erro ao deletar link");
        }
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new RuntimeException("Projeto com ID " + id + " não encontrado.");
        }
        projetoRepository.deleteById(id);
    }
}
