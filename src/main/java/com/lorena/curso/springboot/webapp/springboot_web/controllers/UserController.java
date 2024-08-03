package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    //METODOS HANDLER: manejan peticiones de usuario

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Lorena", "Artieda");
        model.addAttribute("title","Hola mundo con Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

}
