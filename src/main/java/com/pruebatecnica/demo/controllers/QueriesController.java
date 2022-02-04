package com.pruebatecnica.demo.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;
import com.pruebatecnica.demo.entity.HistorialEntity;
import com.pruebatecnica.demo.services.ApiService;

@RestController
@RequestMapping(path = "/v1/demo")
public class QueriesController {

	@Autowired
	private ApiService service;

	@GetMapping(value = "/obtenerPersonaje/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CharacterModel obtenerPersonaje(HttpServletRequest request, @PathVariable(name = "nombre", required = true) String nombre, @RequestParam(name = "historieta", required = false) String historieta, @RequestParam(name = "serie", required = false) String serie) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerPersonaje(sessionUsr, nombre, historieta, serie);
	}

	@GetMapping(value = "/obtenerHistorietasPorPersonaje/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ComicModel> obtenerHistorietasPorPersonaje(HttpServletRequest request, @PathVariable(name = "nombre", required = true) String nombre) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietasPorPersonaje(sessionUsr, nombre);
	}

	@GetMapping(value = "/obtenerImgDescPersonaje/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ImgDescCharacter obtenerImgDescPersonaje(HttpServletRequest request, @PathVariable(name = "nombre", required = true) String nombre) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerImgDescPersonaje(sessionUsr, nombre);
	}

	@GetMapping(value = "/obtenerHistorietas", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/username", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<ComicModel> obtenerHistorietas(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietas(sessionUsr);
	}
	
	@GetMapping(value = "/obtenerHistorietaPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ComicModel obtenerHistorietaPorId(HttpServletRequest request, @PathVariable(name = "id", required = true) String id) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietaPorId(sessionUsr, id);
	}
	
	@GetMapping(value = "/obtenerHistorialPorUsuario/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<HistorialEntity> obtenerHistorialPorUsuario(HttpServletRequest request, @PathVariable(name = "usuario", required = true) String usuario) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorialPorUsuario(sessionUsr, usuario);
	}
	
	@GetMapping(value = "/obtenerHistoretasPorCreador/{idCreador}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ComicModel> obtenerHistoretasPorCreador(HttpServletRequest request, @PathVariable(name = "idCreador", required = true) String creador) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietasPorCreador(sessionUsr, creador);
	}
	
	@GetMapping(value = "/obtenerHistorialHistorietasPorUsuario/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(HttpServletRequest request, @PathVariable(name = "usuario", required = true) String usuario) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorialHistorietasPorUsuario(sessionUsr, usuario);
	}
	
	// pasar a template param a algunos metodos
	
	

}
