package com.pruebatecnica.demo.entity.compositekey;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComicCharacterId implements Serializable {

	private String comicId;
	private String characterId;
	
	public ComicCharacterId(String comicId, String characterId) {
		super();
		this.comicId = comicId;
		this.characterId = characterId;
	}

	public ComicCharacterId() {
		super();
	}
	
	public String getComicId() {
		return comicId;
	}
	
	public void setComicId(String comicId) {
		this.comicId = comicId;
	}
	
	public String getCharacterId() {
		return characterId;
	}
	
	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(characterId, comicId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicCharacterId other = (ComicCharacterId) obj;
		return Objects.equals(characterId, other.characterId) && Objects.equals(comicId, other.comicId);
	}

}
