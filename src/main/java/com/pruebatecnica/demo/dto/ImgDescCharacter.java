package com.pruebatecnica.demo.dto;

public class ImgDescCharacter {

	private String image;
	private String description;
	
	
	public ImgDescCharacter(String image, String description) {
		super();
		this.image = image;
		this.description = description;
	}

	public ImgDescCharacter() {
		super();
	}

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
