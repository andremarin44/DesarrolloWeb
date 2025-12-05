package com.libreria.v1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.libreria.v1.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    @GetMapping("/listar")
    
    public String listUsers(Model model){
        model.addAttribute("listausuarios", userService.getAllUsers());
        return "users/list";
    }
}
