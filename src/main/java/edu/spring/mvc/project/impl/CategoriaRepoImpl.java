package edu.spring.mvc.project.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import edu.spring.mvc.project.domain.entity.Categoria;
import edu.spring.mvc.project.repositories.CategoriaRepository;

@Service
public class CategoriaRepoImpl {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public Categoria saveCategoria(Categoria categoria) {
        Categoria result = null;
        try {
            result = categoriaRepo.save(categoria);

        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }

        return result;
    }
}
