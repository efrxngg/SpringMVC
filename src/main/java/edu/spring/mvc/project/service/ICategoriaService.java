package edu.spring.mvc.project.service;

import java.util.List;

public interface ICategoriaService<E> extends IBaseService<E> {
    List<E> findAloneCategoriaActive() throws Exception;
}
