package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.Admin;
import com.gustavo.portfolio.backend.exceptions.AdminExistenteException;
import com.gustavo.portfolio.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.gustavo.portfolio.backend.exceptions.AdminNotFoundException;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Admin criarAdmin(String email, String senha) {
        Optional<Admin> adminExistente = adminRepository.findByEmail(email);

        if (adminExistente.isPresent()) {
            throw new AdminExistenteException("Erro: já existe esse Admin");
        }

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setSenha(passwordEncoder.encode(senha));
        return adminRepository.save(admin);
    }

    public Admin atualizarAdminSenha(Long id, String novaSenha) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin não encontrado"));
        admin.setSenha(passwordEncoder.encode(novaSenha));
        return adminRepository.save(admin);
    }

    public List<Admin> listarAdmins() {
        return adminRepository.findAll();
    }

    public boolean validarLogin(String email, String senha) {
        Admin admin = adminRepository.findByEmail(email).orElse(null);

        if (admin != null) {
            // Comparar a senha fornecida com a senha criptografada
            return passwordEncoder.matches(senha, admin.getSenha());
        }
        return false;
    }
}
