package edu.spring.mvc.project.utils;

import edu.spring.mvc.project.domain.entity.VideoJuego;

public class Printer {
    public static void videoJuego(VideoJuego game) {
        StringBuilder result = new StringBuilder();
        result
                .append(game.getId_videoJuego()).append("\n")
                .append(game.getTitulo()).append("\n")
                .append(game.getRutaImg()).append("\n")
                .append(game.getPrecio()).append("\n")
                .append(game.getCantidad()).append("\n")
                .append(game.getOferta()).append("\n")
                .append(game.getFecha()).append("\n")
                .append(game.getCategoria().getNombre()).append("\n")
                .append(game.getEstudio().getNombre()).append("\n")
                .append(game.getEstado());

        System.out.println(result);
    }

    

}
