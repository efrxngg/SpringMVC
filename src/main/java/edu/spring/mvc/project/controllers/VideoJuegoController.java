package edu.spring.mvc.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.mvc.project.domain.entity.VideoJuego;
import edu.spring.mvc.project.service.IBaseService;

@Controller
@RequestMapping(value = "videojuegos")
public class VideoJuegoController {

    @Autowired
    private IBaseService<VideoJuego> service;

    @GetMapping
    public String home(Model model) {
        List<VideoJuego> listaVideoJuegos = null;
        try {
            listaVideoJuegos = service.findAllByActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("lista_videojuegos", listaVideoJuegos);
        model.addAttribute("persona", "Efren");
        return "views/videojuego/home";
    }

    public String formAppend() {
        
        return "";
    }
}
