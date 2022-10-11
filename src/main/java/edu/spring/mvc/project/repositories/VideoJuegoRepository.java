package edu.spring.mvc.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.VideoJuego;

@Repository
public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Long>{
    
}
