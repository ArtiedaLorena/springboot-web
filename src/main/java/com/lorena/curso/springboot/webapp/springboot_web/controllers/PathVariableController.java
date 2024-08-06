package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.User;
import com.lorena.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.description}")
    private String description;

    @Autowired
    private Environment env;

    //Ejemplo: http://localhost:8080/api/var/baz/hola
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    //Ejemplo: http://localhost:8080/api/var/mix/medias/1234
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object>mixPathVar(@PathVariable String product, @PathVariable Long id ){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id",id);
        return json;
    }
    @PostMapping("/create")
    public User create(@RequestBody User user){
        //Hacer algo con el usuario
        user.setName(user.getName().toUpperCase());
        return user;
    }


    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("code2", env.getProperty("config.code", Long.class));
        json.put("message", message);
        json.put("message2", env.getProperty("config.message"));
        json.put("listOfValues",listOfValues);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("description", description);

        return json;
    }


}
