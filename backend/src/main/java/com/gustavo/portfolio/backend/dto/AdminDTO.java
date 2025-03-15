package com.gustavo.portfolio.backend.dto;

import com.gustavo.portfolio.backend.entities.Admin;

public class AdminDTO {
    private Long id;
    private String email;
    private String sobreMim;
    private String fotoUrl;

    public AdminDTO() {}

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.sobreMim = admin.getSobreMim();
        this.fotoUrl = admin.getFotoUrl();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSobreMim() {
        return sobreMim;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }
}
