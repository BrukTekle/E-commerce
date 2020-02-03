package edu.mum.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class CartItems {

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
//	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	 @JoinColumn(name="productId")
//	private Product product;
}
