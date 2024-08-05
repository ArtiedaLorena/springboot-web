package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.User;
import com.lorena.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//RestController convierte el metodo handler en un metodo rest
@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path="/details, method=RequestMethod.GET")#Otra forma de escribirlo
    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Lorena", "Artieda", "artiedalorena@gmail.com");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola mundo con Springboot MVC");

        return userDto;
    }
    @GetMapping("/list")
    public List<User>list(){
        User user = new User("Lorena", "Artieda", "artiedalorena@gmail.com");
        User user2 = new User("Pedro", "Garcia", "pedrograrcia@gmail.com");
        User user3 = new User("Martin", "Fernandez", "martinfernandez@gmail.com");


        List<User> users = Arrays.asList(user, user2, user3);
        //List<User>users = new ArrayList<>();
        //users.add(user);
        //users.add(user2);
        //users.add(user3);

        return  users;


    }

}
