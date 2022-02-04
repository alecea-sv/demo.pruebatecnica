package com.pruebatecnica.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.demo.consumers.ApiConsumer;
import com.pruebatecnica.demo.consumers.models.CharacterModel;
import com.pruebatecnica.demo.consumers.models.ComicModel;
import com.pruebatecnica.demo.dto.ImgDescCharacter;
import com.pruebatecnica.demo.entity.CharacterEntity;
import com.pruebatecnica.demo.entity.ComicCharacterEntity;
import com.pruebatecnica.demo.entity.ComicEntity;
import com.pruebatecnica.demo.entity.HistorialEntity;
import com.pruebatecnica.demo.entity.compositekey.ComicCharacterId;
import com.pruebatecnica.demo.repositories.*;
import com.pruebatecnica.demo.utils.DataDemoApiMarvel;

@Service
public class ImplApiService implements ApiService {

	@Autowired
	private ApiConsumer consumer;
	@Autowired
	private CharacterRepository characterRepo;
	@Autowired
	private ComicRepository comicRepo;
	@Autowired
	private ComicCharacterRepository ccRepo;
	@Autowired
	private HistorialRepository historialRepo;
	
	private final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	private static final Logger log = LoggerFactory.getLogger(ImplApiService.class);
	
	@Override
	public CharacterModel obtenerPersonaje(String usrsession, String nombre, String historieta, String serie) {
		
		try {
			consumer.obtenerPersonaje(nombre, historieta, serie);
		} catch (Exception ex) {}
		
		CharacterModel ch = DataDemoApiMarvel.ALL_CHARACTERS.stream().filter(e -> e.getName().equalsIgnoreCase(nombre)).findAny().orElse(null);
		if (ch != null) {
			CharacterEntity cdb = characterRepo.findByName(nombre);
			if (cdb != null) {
				cdb.setModified(sdf.format(new Date()));
			} else {
				cdb = DataDemoApiMarvel.characterModelToEntity(ch);
			}
			characterRepo.save(cdb);

			for (String comid : ch.getComicsIds()) {
				Optional<ComicEntity> dbid = comicRepo.findById(comid);
				if (dbid.isPresent()) {
					ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(comid, ch.getId()), sdf.format(new Date()));
					ccRepo.save(cc);
				}
			}
		}

		guardarRegistroHistorial("obtenerPersonaje", usrsession);
		return ch;
		
	}


	@Override
	public List<ComicModel> obtenerHistorietasPorPersonaje(String usrsession, String nombre) {
		
		List<ComicModel> result = new ArrayList<>();
		CharacterModel ch = DataDemoApiMarvel.ALL_CHARACTERS.stream().filter(e -> e.getName().equalsIgnoreCase(nombre)).findAny().orElse(null);
		if (ch != null) {
			
			try {
				consumer.obtenerHistorietasPorPersonaje(ch.getId());
			} catch (Exception ex) {}

			Set<ComicModel> set = DataDemoApiMarvel.ALL_COMICS.stream().filter(e -> e.getCharactersIds().contains(ch.getId())).collect(Collectors.toSet());
			if (!set.isEmpty()) {
				result = new ArrayList<>(set);
				for (ComicModel comic : result) {
					
					ComicEntity cdb;
					Optional<ComicEntity> optional = comicRepo.findById(comic.getId());
					if (optional.isPresent()) {
						cdb = optional.get();
						cdb.setModified(sdf.format(new Date()));
					} else {
						cdb = DataDemoApiMarvel.comicModelToEntity(comic);
					}
					comicRepo.save(cdb);
					
					for (String charid : comic.getCharactersIds()) {
						Optional<CharacterEntity> dbid = characterRepo.findById(charid);
						if (dbid.isPresent()) {
							ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(comic.getId(), charid), sdf.format(new Date()));
							ccRepo.save(cc);
						}
					}
					
				}

			}

		}
		
		guardarRegistroHistorial("obtenerHistorietasPorPersonaje", usrsession);
		return result;

	}

	@Override
	public ImgDescCharacter obtenerImgDescPersonaje(String usrsession, String nombre) {

		try {
			consumer.obtenerPersonaje(nombre, null, null);
		} catch (Exception ex) {}
		
		ImgDescCharacter idc = null;
		CharacterModel ch = DataDemoApiMarvel.ALL_CHARACTERS.stream().filter(e -> e.getName().equalsIgnoreCase(nombre)).findAny().orElse(null);
		if (ch != null) {
			idc = new ImgDescCharacter(ch.getThumbnail(), ch.getDescription());
			CharacterEntity cdb = characterRepo.findByName(nombre);
			if (cdb != null) {
				cdb.setModified(sdf.format(new Date()));
			} else {
				cdb = DataDemoApiMarvel.characterModelToEntity(ch);
			}
			characterRepo.save(cdb);
			
			for (String comid : ch.getComicsIds()) {
				Optional<ComicEntity> dbid = comicRepo.findById(comid);
				if (dbid.isPresent()) {
					ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(comid, ch.getId()), sdf.format(new Date()));
					ccRepo.save(cc);
				}
			}
			
		}
		guardarRegistroHistorial("obtenerImgDescPersonaje", usrsession);
		return idc;
		
	}

	@Override
	public List<ComicModel> obtenerHistorietas(String usrsession) {
		
		try {
			consumer.obtenerHistorietas();
		} catch (Exception ex) {}
		
		List<ComicModel> result = DataDemoApiMarvel.ALL_COMICS;
		log.info(result.size()+"");
		for (ComicModel comic : result) {
			
			ComicEntity cdb;
			Optional<ComicEntity> optional = comicRepo.findById(comic.getId());
			if (optional.isPresent()) {
				cdb = optional.get();
				cdb.setModified(sdf.format(new Date()));
			} else {
				cdb = DataDemoApiMarvel.comicModelToEntity(comic);
			}
			comicRepo.save(cdb);
			
			for (String charid : comic.getCharactersIds()) {
				Optional<CharacterEntity> dbid = characterRepo.findById(charid);
				if (dbid.isPresent()) {
					ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(comic.getId(), charid), sdf.format(new Date()));
					ccRepo.save(cc);
				}
			}
			
		}
		
		guardarRegistroHistorial("obtenerHistorietas", usrsession);
		return result;
		
	}

	@Override
	public ComicModel obtenerHistorietaPorId(String usrsession, String id) {

		try {
			consumer.obtenerHistorietaPorId(id);
		} catch (Exception ex) {}
		
		ComicModel result = DataDemoApiMarvel.ALL_COMICS.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findAny().orElse(null);
		if (result != null) {
			ComicEntity cdb;
			Optional<ComicEntity> optional = comicRepo.findById(result.getId());
			if (optional.isPresent()) {
				cdb = optional.get();
				cdb.setModified(sdf.format(new Date()));
			} else {
				cdb = DataDemoApiMarvel.comicModelToEntity(result);
			}
			comicRepo.save(cdb);
			
			for (String charid : result.getCharactersIds()) {
				Optional<CharacterEntity> dbid = characterRepo.findById(charid);
				if (dbid.isPresent()) {
					ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(result.getId(), charid), sdf.format(new Date()));
					ccRepo.save(cc);
				}
			}			
		}
		
		guardarRegistroHistorial("obtenerHistorietaPorId", usrsession);
		return result;

	}

	@Override
	public List<HistorialEntity> obtenerHistorialPorUsuario(String usrsession, String usuario) {
		List<HistorialEntity> l = historialRepo.findByUsername(usuario);
		guardarRegistroHistorial("obtenerHistorialPorUsuario", usrsession);
		log.info(l.size()+"");
		return l;
	}

	@Override
	public List<ComicModel> obtenerHistorietasPorCreador(String usrsession, String idCreador) {
        
		try {
			consumer.obtenerHistorietasPorCreador(idCreador);
		} catch (Exception ex) {}

		// aleatorio para generar una muestra
		java.util.Random rn = new java.util.Random();
        int num = rn.nextInt(9) + 1;
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < num; i++) {
        	indexes.add(rn.nextInt(num));
        }

        List<ComicModel> result = new ArrayList<>();
        for (Integer integer : indexes) {
			result.add(DataDemoApiMarvel.ALL_COMICS.get(integer));
		}
        
		log.info(result.size()+"");
		for (ComicModel comic : result) {
			
			ComicEntity cdb;
			Optional<ComicEntity> optional = comicRepo.findById(comic.getId());
			if (optional.isPresent()) {
				cdb = optional.get();
				cdb.setModified(sdf.format(new Date()));
			} else {
				cdb = DataDemoApiMarvel.comicModelToEntity(comic);
			}
			comicRepo.save(cdb);
			
			for (String charid : comic.getCharactersIds()) {
				Optional<CharacterEntity> dbid = characterRepo.findById(charid);
				if (dbid.isPresent()) {
					ComicCharacterEntity cc = new ComicCharacterEntity(new ComicCharacterId(comic.getId(), charid), sdf.format(new Date()));
					ccRepo.save(cc);
				}
			}
			
		}

        guardarRegistroHistorial("obtenerHistorietasPorCreador", usrsession);
		return result;
	}

	@Override
	public List<HistorialEntity> obtenerHistorialHistorietasPorUsuario(String usrsession, String usuario) {		
		List<HistorialEntity> l = historialRepo.findLikeHistorieta(usuario);
		guardarRegistroHistorial("obtenerHistorialPorUsuario", usrsession);
		log.info(l.size()+"");
		return l;
	}

	private void guardarRegistroHistorial(String metodo, String usrsession) {
		
		HistorialEntity h = new HistorialEntity();
		h.setUsername(usrsession);
		h.setSearchType(metodo);
		h.setSearched(sdf.format(new Date()));
		
		log.info(h.toString());
		
		historialRepo.save(h);
	}

}
