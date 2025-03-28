package com.gustavo.portfolio.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nomeRede;

    @NotBlank
    @Column(nullable = false)
    private String url;

    @NotBlank
    @Column(nullable = false)
    private String icone;

    public Contato() {}

    public Contato(Long id, String nomeRede, String url, String icone) {
        this.id = id;
        this.nomeRede = nomeRede;
        this.url = url;
        this.icone = icone;
    }

    public Long getId() {
        return id;
    }

    public Contato setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeRede() {
        return nomeRede;
    }

    public Contato setNomeRede(String nomeRede) {
        this.nomeRede = nomeRede;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Contato setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIcone() {
        return icone;
    }

    public Contato setIcone(String icone) {
        this.icone = icone;
        return this;
    }
}
