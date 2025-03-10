package com.gustavo.portfolio.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 1000)
    @NotBlank(message = "A descrição não pode estar vazia")
    private String descricao;

    @Column(nullable = false, length = 500)
    private String linkGithub;

    @Column(length = 500)
    private String linkHostpedado;

    @Column(nullable = false, length = 500)
    private String imagemUrl;

    public Projeto() {
    }

    public Projeto(long id, String titulo, String descricao, String linkGithub, String linkHostpedado, String imagemUrl) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.linkGithub = linkGithub;
        this.linkHostpedado = linkHostpedado;
        this.imagemUrl = imagemUrl;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    public String getLinkHostpedado() {
        return linkHostpedado;
    }

    public void setLinkHostpedado(String linkHostpedado) {
        this.linkHostpedado = linkHostpedado;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    // Método toString() para depuração
    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", linkGithub='" + linkGithub + '\'' +
                ", linkHostpedado='" + linkHostpedado + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                '}';
    }
}
