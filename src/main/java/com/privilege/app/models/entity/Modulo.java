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
@Table(name = "modulos")
public class Modulo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModulo;
	
	@Column(name="nombreModulo")
	private String nombreModulo;
	String blabla;

	@ManyToOne
    @JoinColumn(name = "fkFuncionalidad", nullable = false, updatable = false)
	private Funcionalidad funcionalidades;
	
	public Modulo() {
		
	}

	public Modulo(Long idModulo, String nombreModulo, Funcionalidad funcionalidades) {
		this.idModulo = idModulo;
		this.nombreModulo = nombreModulo;
		this.funcionalidades = funcionalidades;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public Funcionalidad getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(Funcionalidad funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
	
	
	
}