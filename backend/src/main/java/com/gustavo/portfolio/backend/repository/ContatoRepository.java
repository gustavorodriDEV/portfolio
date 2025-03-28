package com.gustavo.portfolio.backend.repository;

import com.gustavo.portfolio.backend.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
