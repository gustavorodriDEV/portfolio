package com.gustavo.portfolio.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "perfil_apresentacao")
public class PerfilApresentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cargo;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String descricao;

    @NotBlank
    private String fotoUrl;

    public PerfilApresentacao() {}

    public PerfilApresentacao(String nome, String cargo, String descricao, String fotoUrl) {
        this.nome = nome;
        this.cargo = cargo;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
    }

    public Long getId() {
        return id;
    }

    public PerfilApresentacao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PerfilApresentacao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCargo() {
        return cargo;
    }

    public PerfilApresentacao setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public PerfilApresentacao setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public PerfilApresentacao setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
        return this;
    }
}
