package com.api.docker.rest.model;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_address")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 
	private String city;
	
	 
	private String street;
	
	

	  public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	  public UserAddress(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	  public String getCity() {
		  return city;
	  }

	  public void setCity(String city) {
		  this.city = city;
	  }

	  public String getStreet() {
		  return street;
	  }

	  public void setStreet(String street) {
		  this.street = street;
	  }

}
