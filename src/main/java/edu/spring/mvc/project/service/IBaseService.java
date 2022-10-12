package edu.spring.mvc.project.service;

import java.util.List;

public interface IBaseService<E> {

    List<E> findAll() throws Exception;

    List<E> findAllByActive() throws Exception;

    E findById(Long id) throws Exception;

    E findByIdandEstado(Long id) throws Exception;

    E save(E entity) throws Exception;

    E update(E entity, Long id) throws Exception;

    Boolean deleteLogic(Long id) throws Exception;
}
