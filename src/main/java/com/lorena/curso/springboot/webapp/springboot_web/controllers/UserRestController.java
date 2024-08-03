package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.User;
import com.lorena.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//RestController convierte el metodo handler en un metodo rest
@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path="/details, method=RequestMethod.GET")#Otra forma de escribirlo
    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Lorena", "Artieda");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola mundo con Springboot MVC");

        return userDto;
    }

}
