package edu.spring.mvc.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.Estudio;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Long>{
    
}
