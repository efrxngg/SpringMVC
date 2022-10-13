package edu.spring.mvc.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import edu.spring.mvc.project.domain.entity.Estudio;
import edu.spring.mvc.project.repositories.IEstudioRepository;
import edu.spring.mvc.project.service.IEstudioService;

@Service
public class EstudioServiceImpl implements IEstudioService<Estudio> {

    @Autowired
    private IEstudioRepository repository;

    @Override
    @Transactional
    public List<Estudio> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    @Transactional
    public List<Estudio> findAllByActive() throws Exception {
        List<Estudio> result = null;
        try {
            result = repository.findAllByActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public Estudio findById(Long id) throws Exception {
        Estudio entity = null;
        try {
            Optional<Estudio> optinal = repository.findById(id);
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
    public Estudio findByIdandEstado(Long id) throws Exception {
        Estudio result = null;
        try {
            Optional<Estudio> optional = repository.findByIdAndEstado(id);
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
    public Estudio save(Estudio entity) throws Exception {
        Estudio Estudio = null;
        try {
            Estudio = repository.save(entity);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }
        return Estudio;
    }

    @Override
    @Transactional
    public Estudio update(Estudio entity, Long id) throws Exception {
        Estudio result = null;
        try {
            Optional<Estudio> optional = repository.findById(id);
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
            Optional<Estudio> optional = repository.findById(id);
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

    @Override
    public List<Estudio> findAloneEstudioActive() throws Exception {
        List<Estudio> result = null;
        try {
            result = repository.findAloneEstudioActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
