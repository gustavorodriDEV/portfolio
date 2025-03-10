package com.gustavo.portfolio.backend.dto;

import com.gustavo.portfolio.backend.entities.Admin;

public class AdminDTO {
    private Long id;
    private String email;

    public AdminDTO() {}

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
