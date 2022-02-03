package com.pruebatecnica.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebatecnica.demo.Entity.HistorialEntity;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;

@Service
public class ImplApiService implements ApiService {

	@Override
	public CharacterModel obtenerPersonaje(String nombre, String historieta, String serie) {
		CharacterModel obj = new CharacterModel();
		return obj;
	}

	@Override
	public List<ComicModel> obtenerHistorietasPorPersonaje(String nombre) {
		List<ComicModel> l = new ArrayList<>();
		ComicModel c = new ComicModel();
		l.add(c);
		return l;
	}

	@Override
	public ImgDescCharacter obtenerImgDescPersonaje(String nombre) {
		ImgDescCharacter idc = new ImgDescCharacter();
		return idc;
	}

	@Override
	public List<ComicModel> obtenerHistorietas() {
		List<ComicModel> l = new ArrayList<>();
		ComicModel c = new ComicModel();
		l.add(c);
		return l;
	}

	@Override
	public ComicModel obtenerHistorietaPorId(String id) {
		ComicModel c = new ComicModel();
		return c;
	}

	@Override
	public List<HistorialEntity> obtenerHistorialPorUsuario(String usuario) {
		List<HistorialEntity> l = new ArrayList<>();
		HistorialEntity h = new HistorialEntity();
		l.add(h);
		return l;
	}

	@Override
	public List<ComicModel> obtenerHistoretasPorCreador(String creador) {
		List<ComicModel> l = new ArrayList<>();
		ComicModel c = new ComicModel();
		l.add(c);
		return l;
	}

	@Override
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(String usuario) {
		List<HistorialEntity> l = new ArrayList<>();
		HistorialEntity h = new HistorialEntity();
		l.add(h);
		return l;
	}

}
