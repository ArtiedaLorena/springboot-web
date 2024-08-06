package com.lorena.curso.springboot.webapp.springboot_web.controllers;

import com.lorena.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.lorena.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required =false, defaultValue = "Hola que tal?") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;

    }

    //Ejemplo: http://localhost:8080/api/params/bar?text=Hola%20que%20tal&code=33434942
    @GetMapping("bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    //Ejemplo: http://localhost:8080/api/params/request?code=%2012345&message=algun%20mensaje
    @GetMapping("/request")
    public ResponseEntity<ParamMixDto> request(HttpServletRequest request) {
        ParamMixDto params = new ParamMixDto();
        try {
            String codeParam = request.getParameter("code");
            String messageParam = request.getParameter("message");

            // Validar parámetros
            if (codeParam == null || messageParam == null) {
                return ResponseEntity.badRequest().body(null); // o puedes devolver un mensaje de error personalizado
            }

            int code = Integer.parseInt(codeParam.trim()); // Eliminar espacios en blanco
            params.setCode(code);
            params.setMessage(messageParam);

            return ResponseEntity.ok(params);

        } catch (NumberFormatException e) {
            // Manejar la excepción si el parámetro code no es un número válido
            return ResponseEntity.badRequest().body(null); // o puedes devolver un mensaje de error personalizado
        }
    }

}
