package com.privilege.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.privilege.app.models.entity.Privilegio;

@Service
public interface IPrivilegioDAO extends JpaRepository <Privilegio, Long>{
	
	List<Privilegio> findByClavePrivilegio(Long clavePrivilegio);
}
