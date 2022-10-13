package edu.spring.mvc.project.service;

import java.util.List;

public interface IEstudioService<E> extends IBaseService<E> {
    List<E> findAloneEstudioActive() throws Exception;

}
