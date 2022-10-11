package edu.spring.mvc.project.domain.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "videojuego")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoJuego implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_videoJuego;

    private String titulo;
    private String rutaImg;
    private Float precio;
    private int cantidad;
    private String descripcion;
    private Boolean oferta;
    private Date fecha;

    @JoinColumn(name = "fk_categoria", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @JoinColumn(name = "fk_estudio", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Estudio estudio;

    private int estado; 
}
