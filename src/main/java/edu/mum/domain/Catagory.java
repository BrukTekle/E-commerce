package edu.mum.domain;

import java.io.Serializable;
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
public class Catagory implements Serializable {

	
	private static final long serialVersionUID = 748392398L;
	@Id
	@Column(name="cId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(mappedBy="catagory")
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}	
	public void setProducts(List<Product> products) {
		this.products = products;
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
