package edu.mum.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Date date;
    private Integer amount;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "productId")
    private List<Product> products;



    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	 @JoinTable()
//	private List<CartItems> carts;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//	public List<CartItems> getCarts() {
//		return carts;
//	}
//
//	public void setCarts(List<CartItems> carts) {
//		this.carts = carts;
//	}


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
