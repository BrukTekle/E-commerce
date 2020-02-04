package edu.mum.domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.ManyToMany;

import com.mysql.cj.jdbc.Blob;

@Entity
public class Product implements Serializable {
    public void setId(long id) {
		this.id = id;
	}
	private static final long serialVersionUID = 748392348L;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
    private String description;
    private float price;
    private String manufacturer;
	@JsonIgnore 
	@Transient
    private MultipartFile productImage;
//    public void setProductImage(byte[] productImage) {
//		this.productImage = productImage;
//	}
//    
//	public byte[] getProductImage() {
//		return productImage;
//	}
	
	private String imageURL;
public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
    public Catagory getCatagory() {
		return catagory;
	}
	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}
	private int unitsInStock;
    private String condition;
    
//  @OneToMany
    @ManyToOne
    @JoinColumn(name="cId")
   	private Catagory catagory;
    
	public long getId() {
		return id;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
    
    public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	private int amount;
    
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	//    @ManyToMany(mappedBy = "productId")
     @ManyToMany(mappedBy = "products")
	 private List<Orders> orders;

    public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}