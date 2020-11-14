package com.privilege.app.models.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.privilege.app.models.dao.IDescripcionDAO;
import com.privilege.app.models.dao.IFuncionalidadDAO;
import com.privilege.app.models.dao.IModuloDAO;
import com.privilege.app.models.dao.IPrivilegioDAO;
import com.privilege.app.models.dao.IProyectoDAO;
import com.privilege.app.models.dto.FuncionalidadDTO;
import com.privilege.app.models.entity.Descripcion;
import com.privilege.app.models.entity.Funcionalidad;
import com.privilege.app.models.entity.Modulo;
import com.privilege.app.models.entity.Privilegio;
import com.privilege.app.models.entity.Proyecto;

@CrossOrigin(origins = {"https://app-front-urrea.herokuapp.com"})
@RestController
@RequestMapping("/api/funcionalidad")
public class FuncionalidadRestController {

	@Autowired
	private IFuncionalidadDAO funcionalidadService;
	@Autowired
	private IDescripcionDAO descripcionService;
	@Autowired
	private IModuloDAO moduloService;
	@Autowired
	private IPrivilegioDAO privilegioService;
	@Autowired
	private IProyectoDAO proyectoService;
	
	@PostMapping("/crear")
	public  ResponseEntity<?> crear(@Valid @RequestBody List<FuncionalidadDTO> funcionalidaddto, BindingResult result) {
		
		Privilegio privilegioGlogal = new Privilegio();
		privilegioGlogal.setClavePrivilegio(funcionalidaddto.get(0).getPrivilegio().getClavePrivilegio());
		privilegioGlogal.setNombreCorto(funcionalidaddto.get(0).getPrivilegio().getNombreCorto());
		privilegioGlogal.setShortPrivilegio(funcionalidaddto.get(0).getPrivilegio().getShortPrivilegio());
		
		Privilegio priv= new Privilegio();
		priv = privilegioService.save(privilegioGlogal);
		System.out.println(priv.getIdPrivilegio());
		
		for(FuncionalidadDTO fundto: funcionalidaddto) {
			List<Proyecto> proyectos = fundto.getProyectos();
			List<Descripcion> descripciones = fundto.getDescripcion();
			List <Modulo> modulos = fundto.getModulos();
			Funcionalidad funcionalidad = fundto.getFuncionalidad();
			Privilegio privilegio = fundto.getPrivilegio();
			
			for(Proyecto p: proyectos){
				funcionalidad.addProyectos(proyectoService.getOne(p.getIdProyecto()));
			}
		
			funcionalidad.setPrivilegio(privilegioService.getOne(priv.getIdPrivilegio()));
	
			
			Funcionalidad funok = funcionalidadService.save(funcionalidad);
			for(Descripcion des: descripciones) {
				des.setFuncionalidad(funok);
				descripcionService.save(des);
			}
			for(Modulo mod: modulos) {
				mod.setFuncionalidades(funok);
				moduloService.save(mod);
			}
			
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", funcionalidaddto);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
}

