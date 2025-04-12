package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.PerfilApresentacao;
import com.gustavo.portfolio.backend.repository.PerfilApresentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilApresentacaoService {

    @Autowired
    private PerfilApresentacaoRepository perfilRepository;

    public PerfilApresentacao adicionar(String nome, String cargo, String descricao, String fotourl){
        PerfilApresentacao perfil = new PerfilApresentacao(nome, cargo, descricao, fotourl);
        return perfilRepository.save(perfil);
    }

    public List<PerfilApresentacao> listar() {
        return  perfilRepository.findAll();
    }

    public PerfilApresentacao atualizar(Long id, String nome, String cargo, String descricao, String fotoUrl){
        PerfilApresentacao perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error"));

        if (nome != null && !nome.isBlank()){
            perfil.setNome(nome);
        }
        if (cargo != null && !cargo.isBlank()){
            perfil.setCargo(cargo);
        }
        if (descricao != null && !descricao.isBlank()){
            perfil.setDescricao(descricao);
        }
        if (fotoUrl != null && !fotoUrl.isBlank())
            perfil.setFotoUrl(fotoUrl);

        return  perfilRepository.save(perfil);
    }


}
