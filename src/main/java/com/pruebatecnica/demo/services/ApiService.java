package com.pruebatecnica.demo.services;

import java.util.List;

import com.pruebatecnica.demo.Entity.HistorialEntity;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;

public interface ApiService {

	public CharacterModel obtenerPersonaje(String nombre, String historieta, String serie);
	public List<ComicModel> obtenerHistorietasPorPersonaje(String nombre);
	public ImgDescCharacter obtenerImgDescPersonaje(String nombre);
	public List<ComicModel> obtenerHistorietas();
	public ComicModel obtenerHistorietaPorId(String id);
	public List<HistorialEntity> obtenerHistorialPorUsuario(String usuario);
	public List<ComicModel> obtenerHistoretasPorCreador(String creador);
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(String usuario);
	
}
