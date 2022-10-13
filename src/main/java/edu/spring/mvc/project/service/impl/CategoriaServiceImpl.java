package edu.spring.mvc.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import edu.spring.mvc.project.domain.entity.Categoria;
import edu.spring.mvc.project.repositories.ICategoriaRepository;
import edu.spring.mvc.project.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService<Categoria> {

    @Autowired
    private ICategoriaRepository repository;

    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        List<Categoria> result = null;
        try {
            result = repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public List<Categoria> findAllByActive() throws Exception {
        List<Categoria> result = null;
        try {
            result = repository.findAllByActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public Categoria findById(Long id) throws Exception {
        Categoria entity = null;
        try {
            Optional<Categoria> optinal = repository.findById(id);
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
    public Categoria findByIdandEstado(Long id) throws Exception {
        Categoria result = null;
        try {
            Optional<Categoria> optional = repository.findByIdandEstado(id);
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
    public Categoria save(Categoria entity) throws Exception {
        Categoria Categoria = null;
        try {
            Categoria = repository.save(entity);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }
        return Categoria;
    }

    @Override
    @Transactional
    public Categoria update(Categoria entity, Long id) throws Exception {
        Categoria result = null;
        try {
            Optional<Categoria> optional = repository.findById(id);
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
            Optional<Categoria> optional = repository.findById(id);
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
    @Transactional
    public List<Categoria> findAloneCategoriaActive() throws Exception {
        List<Categoria> result = null;
        try {
            result = repository.findAloneCategoriaActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}