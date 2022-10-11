package edu.spring.mvc.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "categoria")
public class CategoriaController {

    @GetMapping(value = "form")
    public String formulario(){
        return "categoria/FormAdd";
    }

    @PostMapping(value = "confirmada")
    public String save(){

        return "Confirmado";
    }
}
