package edu.mum.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 748392348L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotEmpty
	private String name;
    @NotEmpty
    private String description;
    @NotNull
    private Float price;
	private String manufacturer;
	@NotNull
    private Integer amount;
	@JsonIgnore 
	@Transient
    private MultipartFile productImage;
//	private String imageURL;
	private String productCondition;

    @ManyToOne//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="cId")
   	private Catagory catagory;
    
    // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
//    private Orders order;
    
    public void setId(Integer id) {
	this.id = id;
    }
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
    public Float getPrice() {
        return price;
    }

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
    public Integer getAmount() {
		return amount;
	}
	
//	public String getImageURL() {
//		return imageURL;
//	}
//	public void setImageURL(String imageURL) {
//		this.imageURL = imageURL;
//	}
    public Catagory getCatagory() {
		return catagory;
	}
	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}
    
	public Integer getId() {
		return id;
	}

	public String getCondition() {
		return productCondition;
	}
	public void setCondition(String productCondition) {
		this.productCondition = productCondition;
	}
    
    public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@XmlTransient 
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
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