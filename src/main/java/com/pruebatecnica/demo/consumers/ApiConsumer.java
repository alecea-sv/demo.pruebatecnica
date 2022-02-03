package com.pruebatecnica.demo.consumers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pruebatecnica.demo.dto.BusquedaPersonajeReq;
import com.pruebatecnica.demo.utils.InvokeMarvelApiService;

public class ApiConsumer {

	@Autowired
	private InvokeMarvelApiService invokeService;
	
    public Map<String, String> getRucData(BusquedaPersonajeReq req) throws Exception {
        
    	 Map<String, String> queryParams = new HashMap<>();
    	 queryParams.put("name", req.getNombre());
    	 queryParams.put("comics", req.getHistorieta());
    	 queryParams.put("series", req.getSerie());
    	 
        String url = this.invokeService.buildUri(this.invokeService.CHARACTERS, queryParams);
        
        String jsonString = null;
        try {
            jsonString = this.invokeService.invokeGetMethod(url);
        } catch (IOException ex) {
            throw new Exception(ex);
        }
        
        int total = JsonParser.parseString(jsonString).getAsJsonObject().get("data").getAsJsonObject().get("total").getAsInt();
        
        Type type = new TypeToken<Map<String, String>>(){}.getType() ;
        Map<String, String> data = null;
        try {
            Gson gson = new GsonBuilder().setDateFormat(this.invokeService.getDateTimePattern()).create();
            data = gson.fromJson(jsonString, type);
        } catch (JsonSyntaxException | JsonIOException ex) {
            throw new Exception(ex);
        }
        
        return data;
        
    }

}
