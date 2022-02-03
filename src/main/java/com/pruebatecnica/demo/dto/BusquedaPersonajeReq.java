package com.pruebatecnica.demo.dto;

public class BusquedaPersonajeReq {

	private String nombre;
	private String historieta;
	private String serie;
	
	public BusquedaPersonajeReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHistorieta() {
		return historieta;
	}

	public void setHistorieta(String historieta) {
		this.historieta = historieta;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "BusquedaPersonajeReq [nombre=" + nombre + ", historieta=" + historieta + ", serie=" + serie + "]";
	}
	
}
