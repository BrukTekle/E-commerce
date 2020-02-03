package edu.mum.domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 748392348L;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
    private String description;
    private float price;
    
    private int amount;
    private byte[] productImage;
    
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