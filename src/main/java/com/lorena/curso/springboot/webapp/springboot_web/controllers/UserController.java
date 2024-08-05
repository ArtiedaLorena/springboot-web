package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    //METODOS HANDLER: manejan peticiones de usuario

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Lorena", "Artieda", "artiedalorena@gmail.com");
        model.addAttribute("title","Hola mundo con Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }


    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("title", "Listado de Usuarios!");
        return "list";

    }
    //Pasar datos a la vista, que sean comuneas ala mayoria de los metodos del controlador
    @ModelAttribute("users")
    public List<User>usersModel (){
        return  Arrays.asList(
                new User("Lorena", "Artieda", "artiedalorena@gmail.com"),
                new User("Pedro", "Garcia", "pedrograrcia@gmail.com"),
                new User("Martin", "Fernandez", "martinfernandez@gmail.com"));


    }

}
