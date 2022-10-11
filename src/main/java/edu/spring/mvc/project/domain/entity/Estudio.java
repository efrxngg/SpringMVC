package edu.spring.mvc.project.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudio implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_estudio;

    private String nombre;

    @OneToMany(mappedBy = "estudio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VideoJuego> videojuegos;

    private int estado;        

}
