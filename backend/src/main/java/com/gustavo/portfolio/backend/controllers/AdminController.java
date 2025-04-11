package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.dto.AdminDTO;
import com.gustavo.portfolio.backend.dto.AdminCadastroDTO;
import com.gustavo.portfolio.backend.entities.Admin;
import com.gustavo.portfolio.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/cadastro")
    public ResponseEntity<AdminDTO> cadastrarAdmin(@RequestBody AdminCadastroDTO dto) {
        Admin admin = adminService.criarAdmin(dto.getEmail(), dto.getSenha());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdminDTO(admin));
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<AdminDTO> atualizarSenha(@PathVariable Long id, @RequestBody String novaSenha) {
        Admin admin = adminService.atualizarAdminSenha(id, novaSenha);
        return ResponseEntity.ok(new AdminDTO(admin));
    }

    @GetMapping
    public ResponseEntity<List<AdminDTO>> listarAdmins() {
        List<Admin> admins = adminService.listarAdmins();
        List<AdminDTO> adminDTOs = admins.stream()
                .map(AdminDTO::new)
                .toList();
        return ResponseEntity.ok(adminDTOs);
    }

    // Endpoint de Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminDTO adminDTO) {
        boolean loginValido = adminService.validarLogin(adminDTO.getEmail(), adminDTO.getSenha());

        if (loginValido) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
