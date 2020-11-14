package com.privilege.app.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.privilege.app.models.dao.IProyectoDAO;
import com.privilege.app.models.entity.Proyecto;



@CrossOrigin(origins = {"https://app-front-urrea.herokuapp.com"})
@RestController
@RequestMapping("/api/proyecto")
public class ProyectoRestController {
	
	@Autowired
	private IProyectoDAO proyectoService;
	
	@GetMapping("/list")
	public List<Proyecto> index(){
		return proyectoService.findAll();
	}
	
	
	
}
