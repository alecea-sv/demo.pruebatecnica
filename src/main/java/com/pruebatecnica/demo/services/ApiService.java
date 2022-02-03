package com.pruebatecnica.demo.services;

import java.util.List;

import com.pruebatecnica.demo.Entity.HistorialEntity;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;

public interface ApiService {

	public CharacterModel obtenerPersonaje(String usrsession, String nombre, String historieta, String serie);
	public List<ComicModel> obtenerHistorietasPorPersonaje(String usrsession, String nombre);
	public ImgDescCharacter obtenerImgDescPersonaje(String usrsession, String nombre);
	public List<ComicModel> obtenerHistorietas(String usrsession);
	public ComicModel obtenerHistorietaPorId(String usrsession, String id);
	public List<HistorialEntity> obtenerHistorialPorUsuario(String usrsession, String usuario);
	public List<ComicModel> obtenerHistoretasPorCreador(String usrsession, String creador);
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(String usrsession, String usuario);
	
}
