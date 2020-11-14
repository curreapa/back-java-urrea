package com.privilege.app.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "funcionalidades")
public class Funcionalidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionalidad;
	
	@Column(name = "nombreFuncionalidad")
	private String nombreFuncionalidad;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkPrivilegio", nullable = false, updatable = false)
	private Privilegio privilegio;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinTable(name = "func_proyect", joinColumns = @JoinColumn(name = "fkFuncionalidad", nullable = false), inverseJoinColumns = @JoinColumn(name = "fkProyecto", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Proyecto> proyectos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionalidades")
	private List<Modulo> modulos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionalidad")
	private List<Descripcion> descripciones;
	
	public Funcionalidad() {
		
	}

	public Funcionalidad(Long idFuncionalidad, String nombreFuncionalidad, Privilegio privilegio,
			List<Proyecto> proyectos, List<Modulo> modulos, List<Descripcion> descripciones) {
		super();
		this.idFuncionalidad = idFuncionalidad;
		this.nombreFuncionalidad = nombreFuncionalidad;
		this.privilegio = privilegio;
		this.proyectos = proyectos;
		this.modulos = modulos;
		this.descripciones = descripciones;
	}

	public Long getIdFuncionalidad() {
		return idFuncionalidad;
	}

	public void setIdFuncionalidad(Long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getNombreFuncionalidad() {
		return nombreFuncionalidad;
	}

	public void setNombreFuncionalidad(String nombreFuncionalidad) {
		this.nombreFuncionalidad = nombreFuncionalidad;
	}

	public Privilegio getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Descripcion> getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(List<Descripcion> descripciones) {
		this.descripciones = descripciones;
	}
	public void addProyectos(Proyecto proyecto) {
		if (this.proyectos == null) {
			this.proyectos = new ArrayList<>();
		}

		this.proyectos.add(proyecto);
	}
	
}