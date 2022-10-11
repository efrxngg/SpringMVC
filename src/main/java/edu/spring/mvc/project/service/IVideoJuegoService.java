package edu.spring.mvc.project.service;

import java.util.List;

import edu.spring.mvc.project.domain.entity.VideoJuego;

public interface IVideoJuegoService {

    List<VideoJuego> findAllVideoJuegos();
    VideoJuego save(VideoJuego entidad);
    VideoJuego update(VideoJuego entidad);
    VideoJuego deleteLogic(Long id);
}
