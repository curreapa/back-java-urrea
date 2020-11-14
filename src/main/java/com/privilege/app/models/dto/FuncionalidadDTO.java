package com.privilege.app.models.dto;

import java.io.Serializable;
import java.util.List;
import com.privilege.app.models.entity.Funcionalidad;
import com.privilege.app.models.entity.Privilegio;
import com.privilege.app.models.entity.Modulo;
import com.privilege.app.models.entity.Proyecto;
import com.privilege.app.models.entity.Descripcion;

public class FuncionalidadDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Funcionalidad funcionalidad;
	private Privilegio privilegio;
	private List<Modulo> modulos;
	private List<Proyecto> proyectos;
	private List<Descripcion> descripciones;
	
	
	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}
	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	public Privilegio getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}
	public List<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	public List<Descripcion> getDescripcion() {
		return descripciones;
	}
	public void setDescripcion(List<Descripcion> descripciones) {
		this.descripciones = descripciones;
	}
	
	
}
