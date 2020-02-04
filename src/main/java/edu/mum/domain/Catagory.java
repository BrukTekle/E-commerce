package edu.mum.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Catagory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private byte[] catagoryImage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(mappedBy="catagory", cascade = CascadeType.ALL )
	private List<Product> products;
	 
	public List<Product> getProducts() {
		return products;
	}	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public byte[] getCatagoryImage() {
		return catagoryImage;
	}
	public void setCatagoryImage(byte[] catagoryImage) {
		this.catagoryImage = catagoryImage;
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
	
}
