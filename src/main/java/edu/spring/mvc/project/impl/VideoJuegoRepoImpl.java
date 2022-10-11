package edu.spring.mvc.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import edu.spring.mvc.project.domain.entity.VideoJuego;
import edu.spring.mvc.project.repositories.VideoJuegoRepository;
import edu.spring.mvc.project.service.IVideoJuegoService;

@Service
public class VideoJuegoRepoImpl implements IVideoJuegoService {

    @Autowired
    private VideoJuegoRepository videoJuegoRepository;

    @Override
    public List<VideoJuego> findAllVideoJuegos() {
        return videoJuegoRepository.findAll();
    }

    @Override
    public VideoJuego save(VideoJuego entidad) {
        VideoJuego videoJuego = null;
        try {
            videoJuego = videoJuegoRepository.save(entidad);

        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }

        return videoJuego;
    }

    @Override
    public VideoJuego update(VideoJuego entidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VideoJuego deleteLogic(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
