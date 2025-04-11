package com.gustavo.portfolio.backend.dto;

import com.gustavo.portfolio.backend.entities.Admin;

public class AdminDTO {
    private Long id;
    private String email;
    private String role;
    private String senha;

    // Construtor padrão
    public AdminDTO() {}

    // Construtor que recebe um Admin
    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.role = admin.getRole();
        this.senha = admin.getSenha();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
