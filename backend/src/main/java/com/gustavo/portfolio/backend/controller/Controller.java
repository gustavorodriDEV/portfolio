package com.gustavo.portfolio.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
public class Controller {

    @GetMapping("/teste")
    public String teste(){
        return "Backend está rodando perfeitamente!";
    }
}
