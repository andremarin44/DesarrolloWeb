package com.libreria.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/novedades")
    public String novedades() { 
        return "novedades"; 
    }

    @GetMapping("/categoria")
    public String categoria() { 
        return "categoria"; 
    }

    @GetMapping("/contacto")
    public String contacto() { 
        return "contacto"; 
    }
}
