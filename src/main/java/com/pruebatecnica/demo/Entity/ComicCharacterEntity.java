package com.pruebatecnica.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.pruebatecnica.demo.entity.compositekey.ComicCharacterId;

@Entity()
@Table(name = "COMIC_CHARACTER")
//@IdClass(ComicCharacterId.class)
public class ComicCharacterEntity {

	@EmbeddedId
	private ComicCharacterId id;
	private String modified;

//	@Id
//    private String comicId;
//	@Id
//    private String characterId;

	public ComicCharacterEntity() {
		super();
	}

	public ComicCharacterEntity(ComicCharacterId id, String modified) {
		super();
		this.id = id;
		this.modified = modified;
	}

	public ComicCharacterId getId() {
		return id;
	}

	public void setId(ComicCharacterId id) {
		this.id = id;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

//	public String getComicId() {
//		return comicId;
//	}
//	public void setComicId(String comicId) {
//		this.comicId = comicId;
//	}
//	public String getCharacterId() {
//		return characterId;
//	}
//	public void setCharacterId(String characterId) {
//		this.characterId = characterId;
//	}

}
