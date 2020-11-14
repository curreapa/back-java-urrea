package com.privilege.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.privilege.app.models.entity.Modulo;

public interface IModuloDAO extends JpaRepository <Modulo, Long>{
	
}
