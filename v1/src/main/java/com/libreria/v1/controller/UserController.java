package com.libreria.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libreria.v1.Model.UserModel;
import com.libreria.v1.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/users")
@Tag(name = "Usuarios", description = "Operaciones CRUD para usuarios")
public class UserController {

    @Autowired
    UserService userService;

    // LISTAR USUARIOS
    @GetMapping("/listar")
    @Operation(
        summary = "Listar usuarios",
        description = "Devuelve la lista de todos los usuarios registrados"
    )
    public String listUsers(Model model) {
        model.addAttribute("listaUsuarios", userService.getAllUsers());
        return "users/list";
    }

    // FORMULARIO REGISTRO
    @GetMapping("/registrar")
    @Operation(
        summary = "Mostrar formulario de registro",
        description = "Carga la vista del formulario para registrar un nuevo usuario"
    )
    public String showRegisterForm(Model model) {
        model.addAttribute("usuario", new UserModel());
        return "users/registrar";
    }

    // GUARDAR NUEVO USUARIO
    @PostMapping("/guardar")
    @Operation(
        summary = "Guardar nuevo usuario",
        description = "Procesa los datos enviados desde el formulario y guarda un usuario en la base de datos"
    )

    public String saveUser(UserModel user) {
    userService.saveUser(user);   // ✔ Usa el que encripta
    return "redirect:/users/listar";
}


    // FORMULARIO DE EDICIÓN
    @GetMapping("/editar/{id}")
    @Operation(
        summary = "Editar usuario",
        description = "Carga el formulario con los datos del usuario para editarlo"
    )
    public String showEditForm(@PathVariable Long id, Model model) {
        UserModel user = userService.findById(id);

        if (user == null) {
            return "redirect:/users/listar";
        }

        model.addAttribute("usuario", user);
        return "users/editar";
    }

    // ACTUALIZAR USUARIO
    @PostMapping("/actualizar")
    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza los datos del usuario enviado desde el formulario"
    )
    public String updateUser(UserModel user) {
        userService.update(user);
        return "redirect:/users/listar";
    }

    // ELIMINAR USUARIO
    @GetMapping("/eliminar/{id}")
    @Operation(
        summary = "Eliminar usuario",
        description = "Elimina un usuario por su ID"
    )
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/listar";
    }
     @GetMapping("/login")
    public String login() {
        return "login";  // SIN .html
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
