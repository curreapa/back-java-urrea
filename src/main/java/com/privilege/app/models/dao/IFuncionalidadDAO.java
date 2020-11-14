package com.privilege.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.privilege.app.models.entity.Funcionalidad;

public interface IFuncionalidadDAO extends JpaRepository <Funcionalidad , Long>{
	
}
