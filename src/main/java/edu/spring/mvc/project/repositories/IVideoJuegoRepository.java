package edu.spring.mvc.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.VideoJuego;

@Repository
public interface IVideoJuegoRepository extends JpaRepository<VideoJuego, Long> {
    @Query(value = "select * from videojuego vj where vj.estado = 1", nativeQuery = true)
    List<VideoJuego> findAllByActive();

    @Query(value = "select * from videojuego vj where vj.id = :id and vj.estado = 1", nativeQuery = true)
    Optional<VideoJuego> findByIdandEstado(@Param("id") Long id);
}
