package edu.spring.mvc.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.spring.mvc.project.service.IVideoJuegoService;

@Controller
public class VideoJuegoController {

    @Autowired
    private IVideoJuegoService videoJuegoService;

    public String formAppend() {
        videoJuegoService.findAllVideoJuegos();
        return "";
    }
}
