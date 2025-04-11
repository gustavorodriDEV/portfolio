package com.gustavo.portfolio.backend.service;

import com.gustavo.portfolio.backend.entities.Admin;
import com.gustavo.portfolio.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin não encontrado"));

        return User.builder()
                .username(admin.getEmail())
                .password(admin.getSenha())
                .roles("ADMIN")
                .build();
    }
}
