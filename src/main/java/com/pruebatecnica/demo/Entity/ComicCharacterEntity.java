package com.pruebatecnica.demo.Entity;

import javax.persistence.Table;

@Table(name = "COMIC_CHARACTER")
public class ComicCharacterEntity {

    private String idComic;
    private String idCharacter;

    public ComicCharacterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdComic() {
		return idComic;
	}

	public void setIdComic(String idComic) {
		this.idComic = idComic;
	}

	public String getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(String idCharacter) {
		this.idCharacter = idCharacter;
	}

}
