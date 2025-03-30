package com.gustavo.portfolio.backend.dto;

import com.gustavo.portfolio.backend.entities.Admin;

public class AdminDTO {
    private Long id;
    private String email;
    private String nome;
    private String profissao;
    private String sobreMim;
    private String fotoUrl;

    public AdminDTO() {}

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.nome = admin.getNome();
        this.profissao = admin.getProfissao();
        this.sobreMim = admin.getSobreMim();
        this.fotoUrl = admin.getFotoUrl();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getSobreMim() {
        return sobreMim;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }
}
