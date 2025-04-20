package com.gustavo.portfolio.backend.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class UploadController {

    @Value("${upload.icone.dir}")
    private String uploadDir;

    @PostMapping("/icone")
    public ResponseEntity<String> uploadIcone(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo vazio");
        }

        String nomeArquivo = file.getOriginalFilename();
        Path caminho = Paths.get("src/main/resources/static/img/" + nomeArquivo);
        Files.write(caminho, file.getBytes());

        return ResponseEntity.ok("img/" + nomeArquivo);
    }

    @PostMapping("/foto")
    public ResponseEntity<String> uploadFoto(@RequestParam("file") MultipartFile file) {
        try {
            String nomeArquivo = file.getOriginalFilename();

            // Caminho real baseado na raiz do projeto
            String pastaDestino = Paths.get("").toAbsolutePath() + "/uploads/img/";

            File pasta = new File(pastaDestino);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            File destino = new File(pasta, nomeArquivo);
            file.transferTo(destino);

            System.out.println("UPLOAD OK: " + destino.getAbsolutePath());

            return ResponseEntity.ok("uploads/img/" + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + e.getMessage());
        }
    }
}
