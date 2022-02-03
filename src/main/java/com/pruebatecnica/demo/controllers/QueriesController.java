package com.pruebatecnica.demo.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.demo.Entity.HistorialEntity;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;
import com.pruebatecnica.demo.services.ApiService;

@RestController
@RequestMapping(path = "/v1/demo")
public class QueriesController {

	@Autowired
	private ApiService service;

	@GetMapping(value = "/obtenerPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CharacterModel obtenerPersonaje(HttpServletRequest request, @RequestParam(name = "nombre", required = true) String nombre, @RequestParam(name = "historieta", required = false) String historieta, @RequestParam(name = "serie", required = false) String serie) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerPersonaje(sessionUsr, nombre, historieta, serie);
	}

	@GetMapping(value = "/obtenerHistorietasPorPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ComicModel> obtenerHistorietasPorPersonaje(HttpServletRequest request, @RequestParam(name = "nombre", required = true) String nombre) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietasPorPersonaje(sessionUsr, nombre);
	}

	@GetMapping(value = "/obtenerImgDescPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ImgDescCharacter obtenerImgDescPersonaje(HttpServletRequest request, @RequestParam(name = "nombre", required = true) String nombre) {
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
	
	@GetMapping(value = "/obtenerHistorietaPorId", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ComicModel obtenerHistorietaPorId(HttpServletRequest request, @RequestParam(name = "id", required = true) String id) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorietaPorId(sessionUsr, id);
	}
	
	@GetMapping(value = "/obtenerHistorialPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<HistorialEntity> obtenerHistorialPorUsuario(HttpServletRequest request, @RequestParam(name = "usuario", required = true) String usuario) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorialPorUsuario(sessionUsr, usuario);
	}
	
	@GetMapping(value = "/obtenerHistoretasPorCreador", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ComicModel> obtenerHistoretasPorCreador(HttpServletRequest request, @RequestParam(name = "usuario", required = true) String creador) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistoretasPorCreador(sessionUsr, creador);
	}
	
	@GetMapping(value = "/obtenerHistorialHistorietasPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(HttpServletRequest request, @RequestParam(name = "usuario", required = true) String usuario) {
		Principal principal = request.getUserPrincipal();
		String sessionUsr = principal.getName();
		return service.obtenerHistorialHistorietasPorUsuario(sessionUsr, usuario);
	}
	

}
