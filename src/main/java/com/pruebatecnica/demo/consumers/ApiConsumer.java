package com.pruebatecnica.demo.consumers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pruebatecnica.demo.utils.InvokeMarvelApiService;

@Component
public class ApiConsumer {

	private static final Logger log = LoggerFactory.getLogger(ApiConsumer.class);

	@Autowired
	private InvokeMarvelApiService invokeService;

	public Map<String, String> obtenerPersonaje(String nombre, String historieta, String serie) throws Exception {

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("name", nombre);
		if (historieta != null && !historieta.trim().isEmpty()) {
			queryParams.put("comics", historieta);
		}
		if (serie != null && !serie.trim().isEmpty()) {
			queryParams.put("series", serie);
		}

		String url = this.invokeService.buildUri(this.invokeService.CHARACTERS, queryParams);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

//        int total = JsonParser.parseString(jsonString).getAsJsonObject().get("data").getAsJsonObject().get("total").getAsInt();
//        
//        Type type = new TypeToken<Map<String, String>>(){}.getType() ;
//        Map<String, String> data = null;
//        try {
//            Gson gson = new GsonBuilder().setDateFormat(this.invokeService.getDateTimePattern()).create();
//            data = gson.fromJson(jsonString, type);
//        } catch (JsonSyntaxException | JsonIOException ex) {
//            throw new Exception(ex);
//        }

		return null;

	}

	public void obtenerHistorietasPorPersonaje(String charid) throws Exception {
		
		String url = this.invokeService.buildUri(String.format(this.invokeService.CHARACTERS_COMICS, charid), null);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

		return;

	}

	public void obtenerImgDescPersonaje(String nombre) throws Exception {
		
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("name", nombre);
		String url = this.invokeService.buildUri(this.invokeService.CHARACTERS, queryParams);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

		return;

	}

	public void obtenerHistorietas() throws Exception {
		
		String url = this.invokeService.buildUri(this.invokeService.COMICS, null);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

		return;

	}

	public void obtenerHistorietaPorId(String id) throws Exception {
		
		String url = this.invokeService.buildUri(String.format(this.invokeService.COMICS_ID, id), null);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

		return;

	}


	public void obtenerHistorietasPorCreador(String id) throws Exception {
		
		String url = this.invokeService.buildUri(String.format(this.invokeService.CREATORS_COMICS, id), null);
		log.info(url);

		String jsonString = null;
		try {
			jsonString = this.invokeService.invokeGetMethod(url);
			log.info(jsonString);
		} catch (IOException ex) {
			throw new Exception(ex);
		}

		return;

	}

}
