package edu.spring.mvc.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    @Query(value = "select * from categoria c where c.estado = 1", nativeQuery = true)
    List<Categoria> findAllByActive();

    @Query(value = "select * from categoria c where c.id = :id and c.estado = 1")
    Categoria findByIdandEstado(@Param("id") Long id);
}
