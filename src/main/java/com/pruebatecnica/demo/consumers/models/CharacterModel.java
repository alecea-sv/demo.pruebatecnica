package com.pruebatecnica.demo.consumers.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CharacterModel implements Serializable {

	private final static long serialVersionUID = 2905971915831300704L;

	private String id;
	private String name;
	private String description;
	private String modified;
	private String resourceURI;
	private String thumbnail;
	@JsonIgnore
	private List<String> comicsIds;

	public CharacterModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<String> getComicsIds() {
		if (comicsIds == null) {
			comicsIds = new ArrayList<>();
		}
		return comicsIds;
	}

	public void setComicsIds(List<String> comicsIds) {
		this.comicsIds = comicsIds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterModel other = (CharacterModel) obj;
		return Objects.equals(id, other.id);
	}

}
