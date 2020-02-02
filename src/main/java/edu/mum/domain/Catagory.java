package edu.mum.domain;

import org.springframework.web.multipart.MultipartFile;

public class Catagory {

	private int id;
	private String name;
	private String description;
	private MultipartFile catagoryImage;
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
	public MultipartFile getCatagoryImage() {
		return catagoryImage;
	}
	public void setCatagoryImage(MultipartFile catagoryImage) {
		this.catagoryImage = catagoryImage;
	}
	
}
