package edu.mum.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


//@Entity(name="MEMBR") 
@Entity
public class Members {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
	
	@Column(length = 16)
	@Size(min = 4, max = 50, message = "{Size.name.validation}")
	private String firstName;
	
	@Column(length = 16)
	@Size(min = 4, max = 50, message = "{Size.name.validation}")
	private String lastName;

//	@NotNull
//	@Past
// 	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	private Date dateOfBirth;
 	
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotEmpty
	private String phone;
	
	@Valid
	@OneToOne(fetch=FetchType.LAZY) 
 	@JoinColumn(name="member_id") 
 	UserCredentials userCredentials;
	
	@Valid
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) 
 	@JoinColumn(name="addressId")
	Address address;
	
	 @Valid
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	 @JoinColumn(name="memberId") 
	 private List<Orders> orders;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
	public List<Orders> getOrders() {

		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
  
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

 	public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

  }
