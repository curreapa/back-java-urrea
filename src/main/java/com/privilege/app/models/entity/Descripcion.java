package com.privilege.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "descripciones")
public class Descripcion{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDescripcion;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="elemento")
	private String elemento;
	@Column(name="archivo")
	private String archivo;
	@ManyToOne
    @JoinColumn(name = "fkFuncionalidad", nullable = false, updatable = false)
	private Funcionalidad funcionalidad;
	
	public Descripcion() {
		
	}

	public Descripcion(Long idDescripcion, String descripcion, String elemento, String archivo,
			Funcionalidad funcionalidad) {
		this.idDescripcion = idDescripcion;
		this.descripcion = descripcion;
		this.elemento = elemento;
		this.archivo = archivo;
		this.funcionalidad = funcionalidad;
	}

	public Long getIdDescripcion() {
		return idDescripcion;
	}

	public void setIdDescripcion(Long idDescripcion) {
		this.idDescripcion = idDescripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	
}
