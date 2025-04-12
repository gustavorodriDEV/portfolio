package com.gustavo.portfolio.backend.repository;

import com.gustavo.portfolio.backend.entities.PerfilApresentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilApresentacaoRepository extends JpaRepository<PerfilApresentacao, Long> {
}
