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

    public Admin criarAdmin(Admin admin){
        Optional<Admin> adminExistente = adminRepository.findByEmail(admin.getEmail());

        if (adminExistente.isPresent()){
            throw new AdminExistenteException("Erro: ja existe esse Admin");
        }

        admin.setSenha(passwordEncoder.encode(admin.getSenha()));
        return adminRepository.save(admin);
    }

    public List<Admin> listaAdmins(){
        return adminRepository.findAll();
    }

    public Admin buscarAdminPorId(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("Admin não encontrado"));
    }

    public Admin atualizarAdmin(Long id, Admin adminAtualizado) {
        Admin admin = buscarAdminPorId(id);

        if (adminAtualizado.getEmail() != null && !adminAtualizado.getEmail().isEmpty()) {
            Optional<Admin> adminExistente = adminRepository.findByEmail(adminAtualizado.getEmail());
            if (adminExistente.isPresent() && !adminExistente.get().getId().equals(id)) {
                throw new AdminExistenteException("Já existe um Admin com este e-mail!");
            }
            admin.setEmail(adminAtualizado.getEmail());
        }

        if (adminAtualizado.getSenha() != null && !adminAtualizado.getSenha().isEmpty()) {
            admin.setSenha(passwordEncoder.encode(adminAtualizado.getSenha()));
        }

        return adminRepository.save(admin);
    }


    public void deletarAdmin(Long id){
         adminRepository.deleteById(id);
    }
}
