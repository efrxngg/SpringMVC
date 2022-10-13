package edu.spring.mvc.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.spring.mvc.project.domain.entity.Categoria;
import edu.spring.mvc.project.domain.entity.Estudio;
import edu.spring.mvc.project.domain.entity.VideoJuego;
import edu.spring.mvc.project.service.ICategoriaService;
import edu.spring.mvc.project.service.IEstudioService;
import edu.spring.mvc.project.service.IVideoJuegoService;

@Controller
@RequestMapping(value = "/videojuegos")
public class VideoJuegoController {

    @Autowired
    private IVideoJuegoService<VideoJuego> videoJuegoService;

    @Autowired
    private ICategoriaService<Categoria> categoriaService;

    @Autowired
    private IEstudioService<Estudio> estudioService;

    @GetMapping
    public String home(Model model) {
        List<VideoJuego> listaVideoJuegos = null;
        try {
            listaVideoJuegos = videoJuegoService.findAllByActive();
            model.addAttribute("lista_videojuegos", listaVideoJuegos);
            model.addAttribute("persona", "Efren");
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
        var listaVideoJuegos = videoJuegoService.findAllByActive().stream()
                .filter(vj -> vj.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("lista_videojuegos", listaVideoJuegos);
        model.addAttribute("persona", titulo);
        return "views/videojuego/home";
    }

    @GetMapping(value = "/form")
    public String form(Model model, @ModelAttribute("videojuego") VideoJuego videojuego) throws Exception {
        var lista = categoriaService.findAloneCategoriaActive();
        var lista2 = estudioService.findAloneEstudioActive();
        model.addAttribute("categorias", lista);
        model.addAttribute("estudios", lista2);
        return "views/videojuego/form";
    }

    @PostMapping(value = "/add")
    public String add(
            //@RequestParam("archivo") MultipartFile archivo,
            @Valid @ModelAttribute("videojuego") VideoJuego videojuego,
            Model model,
            BindingResult result
    ) throws Exception {
        videojuego.setEstado(1);
        videoJuegoService.save(videojuego);
        return "redirect:/videojuegos";
    }
}
