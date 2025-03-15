package com.gustavo.portfolio.backend.controllers;

import com.gustavo.portfolio.backend.dto.AdminDTO;
import com.gustavo.portfolio.backend.entities.Admin;
import com.gustavo.portfolio.backend.service.AdminService;
import jakarta.validation.Valid;
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

    @GetMapping("/teste")
    public String teste(){
        return "Backend está rodando perfeitamente!";
    }

    @PostMapping
    public ResponseEntity<AdminDTO> criarAdmin(@Valid @RequestBody Admin admin) {
        Admin adminAdicionado = adminService.criarAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdminDTO(adminAdicionado));
    }

    @GetMapping
    public ResponseEntity<List<AdminDTO>> listarAdmins() {
        List<Admin> admins = adminService.listaAdmins();
        List<AdminDTO> adminDTOs = admins.stream()
                .map(AdminDTO::new)
                .toList();

        return ResponseEntity.ok(adminDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> buscarAdminPorId(@PathVariable Long id) {
        Admin admin = adminService.buscarAdminPorId(id);
        return ResponseEntity.ok(new AdminDTO(admin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDTO> atualizarAdmin(
            @PathVariable Long id,
            @RequestBody Admin adminAtualizado) {

        Admin admin = adminService.atualizarAdmin(id, adminAtualizado);

        return ResponseEntity.ok(new AdminDTO(admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdmin(@PathVariable Long id){
        adminService.deletarAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
