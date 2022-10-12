package edu.spring.mvc.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import edu.spring.mvc.project.domain.entity.VideoJuego;
import edu.spring.mvc.project.repositories.IVideoJuegoRepository;
import edu.spring.mvc.project.service.IBaseService;

@Service
public class VideoJuegoServiceImpl implements IBaseService<VideoJuego> {

    @Autowired
    private IVideoJuegoRepository repository;

    @Override
    @Transactional
    public List<VideoJuego> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    @Transactional
    public List<VideoJuego> findAllByActive() {
        return repository.findAllByActive();
    }

    @Override
    @Transactional
    public VideoJuego findById(Long id) throws Exception {
        VideoJuego entity = null;
        try {
            Optional<VideoJuego> optinal = repository.findById(id);
            if (optinal.isEmpty()) {
                entity = optinal.get();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    @Transactional
    public VideoJuego findByIdandEstado(Long id) throws Exception {
        VideoJuego result = null;
        try {
            Optional<VideoJuego> optional = repository.findByIdandEstado(id);
            if (optional.isEmpty()) {
                result = optional.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public VideoJuego save(VideoJuego entity) throws Exception {
        VideoJuego videoJuego = null;
        try {
            videoJuego = repository.save(entity);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }
        return videoJuego;
    }

    @Override
    @Transactional
    public VideoJuego update(VideoJuego entity, Long id) throws Exception {
        VideoJuego result = null;
        try {
            Optional<VideoJuego> optional = repository.findById(id);
            if (optional.isEmpty()) {
                result = optional.get();
                result = repository.save(entity);
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public Boolean deleteLogic(Long id) throws Exception {
        Boolean result = false;
        try {
            Optional<VideoJuego> optional = repository.findById(id);
            if (optional.isEmpty()) {
                var entity = optional.get();
                entity.setEstado(0);
                repository.save(entity);
                result = true;
            }
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }
        return result;
    }
}
