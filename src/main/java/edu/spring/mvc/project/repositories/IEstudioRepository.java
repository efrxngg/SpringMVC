package edu.spring.mvc.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.Estudio;

@Repository
public interface IEstudioRepository extends JpaRepository<Estudio, Long>{
    @Query(value = "select * from estudio e where e.estado=1", nativeQuery = true)
    List<Estudio> findAllByActive();

    @Query(value = "select * from estudio e where e.id_estudio = :id and e.estado=1", nativeQuery = true)
    Optional<Estudio> findByIdAndEstado(@Param("id") Long id);
}
