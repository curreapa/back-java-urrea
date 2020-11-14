package com.privilege.app.models.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	
	@Column(name="nombreProyecto")
	private String nombreProyecto;
	
	
	@ManyToMany(mappedBy = "proyectos", fetch=FetchType.LAZY)
	private List<Funcionalidad> funcionalidades;
	
	public Proyecto() {
		
	}

	public Proyecto(Long idProyecto, String nombreProyecto) {
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
	}


	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

}
