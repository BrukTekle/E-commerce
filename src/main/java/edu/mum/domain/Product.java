package edu.mum.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 748392348L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotEmpty
	private String name;
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
    
    public void setId(Long id) {
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
    
	public Long getId() {
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