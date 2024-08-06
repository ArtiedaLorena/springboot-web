package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //Inicia un nuevo request redirigiendo a la nueva pagina
    @GetMapping({"", "/","/home"})
    public String home(){
        return"redirect:/list";
    }
    //No reinicia un request, mantiene la ruta original
    @GetMapping({"/home2"})
    public String home2(){
        return"forward:/details";
    }
}
