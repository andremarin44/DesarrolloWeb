package com.libreria.v1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreria.v1.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // GET → lista de usuarios
    @GetMapping("/listar")
    public String listUsers(Model model){
        model.addAttribute("listausuarios", userService.getAllUsers());
        return "users/list";
    }

    // POST → recibe datos del formulario contacto.html
    @PostMapping("/enviarContacto")
    public String enviarContacto(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("telefono") String telefono,
            Model model) {

        // Aquí procesas los datos (enviar a BD, correo, etc.)
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);

        model.addAttribute("mensaje", "Formulario enviado correctamente!");

        return "contacto"; // vuelve a la página contacto.html
    }
}
