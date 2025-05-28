package com.api.docker.rest.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {
	
	  @NotBlank(message = "[Address] La ciudad es requerida.")
	  private String city;

	  @NotBlank(message = "[Address] La calle es requerida.")
	  private String street;
	  
	  

	  public AddressDTO(String city, String street) {
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
