package com.pruebatecnica.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "HISTORIAL")
public class HistorialEntity {

	@Id
	private String searched;
	private String username;
	private String searchType;
	
	public HistorialEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearched() {
		return searched;
	}

	public void setSearched(String searched) {
		this.searched = searched;
	}

	@Override
	public String toString() {
		return "HistorialEntity [searched=" + searched + ", username=" + username + ", searchType=" + searchType + "]";
	}
	
}
