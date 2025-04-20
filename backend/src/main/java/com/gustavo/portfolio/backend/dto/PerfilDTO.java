package com.gustavo.portfolio.backend.dto;
import jakarta.validation.constraints.NotBlank;

public class PerfilDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O cargo é obrigatório.")
    private String cargo;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    private String fotoUrl; // pode ser opcional, pois em modo edição ele pode já estar preenchido

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}