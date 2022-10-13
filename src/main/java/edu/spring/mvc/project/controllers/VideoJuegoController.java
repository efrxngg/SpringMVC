package edu.spring.mvc.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            model.addAttribute("lista_videojuegos", listaVideoJuegos);
            model.addAttribute("persona", "Efren");
            // throw new Exception("");
            return "views/videojuego/home";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            e.printStackTrace();
            return "views/error/404";
        }
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(value = "query", required = false) String titulo, Model model) throws Exception {
        System.out.println(titulo);
        var listaVideoJuegos = service.findAllByActive().stream()
            .filter(vj -> vj.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            .collect(Collectors.toList());

        model.addAttribute("lista_videojuegos", listaVideoJuegos);
        model.addAttribute("persona", titulo);
        return "views/videojuego/home";
    }

    @GetMapping(value = "form")
    public String formView() {
        return "views/videojuego/form";
    }

    @PostMapping(value = "add")
    public String add() {

        return "views/videojuego/home";
    }
}
