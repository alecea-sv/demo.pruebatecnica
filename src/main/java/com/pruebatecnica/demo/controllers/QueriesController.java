package com.pruebatecnica.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.demo.Entity.HistorialEntity;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;
import com.pruebatecnica.demo.services.ApiService;

@RestController
@RequestMapping("/v1/demo")
public class QueriesController {

	@Autowired
	private ApiService service;

	@GetMapping(value = "/obtenerPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	public CharacterModel obtenerPersonaje(@RequestParam(name = "nombre", required = true) String nombre, @RequestParam(name = "historieta", required = false) String historieta, @RequestParam(name = "serie", required = false) String serie) {
		return service.obtenerPersonaje(nombre, historieta, serie);
	}

	@GetMapping(value = "/obtenerHistorietasPorPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ComicModel> obtenerHistorietasPorPersonaje(@RequestParam(name = "nombre", required = true) String nombre) {
		return service.obtenerHistorietasPorPersonaje(nombre);
	}

	@GetMapping(value = "/obtenerImgDescPersonaje", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImgDescCharacter obtenerImgDescPersonaje(@RequestParam(name = "nombre", required = true) String nombre) {
		return service.obtenerImgDescPersonaje(nombre);
	}

	@GetMapping(value = "/obtenerHistorietas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ComicModel> obtenerHistorietas() {
		return service.obtenerHistorietas();
	}
	
	@GetMapping(value = "/obtenerHistorietaPorId", produces = MediaType.APPLICATION_JSON_VALUE)
	public ComicModel obtenerHistorietaPorId(@RequestParam(name = "id", required = true) String id) {
		return service.obtenerHistorietaPorId(id);
	}
	
	@GetMapping(value = "/obtenerHistorialPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HistorialEntity> obtenerHistorialPorUsuario(@RequestParam(name = "usuario", required = true) String usuario) {
		return service.obtenerHistorialPorUsuario(usuario);
	}
	
	@GetMapping(value = "/obtenerHistoretasPorCreador", produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerHistoretasPorCreador(@RequestParam(name = "usuario", required = true) String creador) {
		return "Hola";
	}
	
	@GetMapping(value = "/obtenerHistorialHistorietasPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerHistorialHistorietasPorUsuario(@RequestParam(name = "usuario", required = true) String usuario) {
		return "Hola";
	}
	

}
