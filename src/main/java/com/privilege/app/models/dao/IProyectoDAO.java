package com.privilege.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.privilege.app.models.entity.Proyecto;

public interface IProyectoDAO extends JpaRepository <Proyecto, Long>{
	
}
