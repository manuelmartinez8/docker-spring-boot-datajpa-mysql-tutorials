package com.api.docker.rest.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class UserSignupRequest {
	
	  @NotBlank(message = "El Nombre de usuario es requerido.")
	  @Size(min = 3, max = 20, message = "El username debe ser de  3 a 20 caracteres.")
	  private String username;

	  @NotEmpty(message = "El email es requerido.")
	  @Email(message = "El email no es valido.")
	  private String email;

	  @NotNull(message = "La edad es requerida.")
	  @Min(value = 18, message = "La edad debe ser igual o mayor 18")
	  private int age;

	  @NotNull(message = "La fecha de graduacion es requerida.")
	  @Past(message = "La fecha de graduacion debe estar en el pasado.")
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date graduationDate;

	  @NotBlank(message = "La clave es requerida.")
	  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
	  private String password;

	  @NotBlank(message = "El confirmar clave es requerido.")
	  private String confirmPassword;

	  @Valid
	  @NotNull(message = "La direccion es requerida.")
	  private AddressDTO address;

	  public String getUsername() {
		  return username;
	  }

	  public void setUsername(String username) {
		  this.username = username;
	  }

	  public String getEmail() {
		  return email;
	  }

	  public void setEmail(String email) {
		  this.email = email;
	  }

	  public int getAge() {
		  return age;
	  }

	  public void setAge(int age) {
		  this.age = age;
	  }

	  public Date getGraduationDate() {
		  return graduationDate;
	  }

	  public void setGraduationDate(Date graduationDate) {
		  this.graduationDate = graduationDate;
	  }

	  public String getPassword() {
		  return password;
	  }

	  public void setPassword(String password) {
		  this.password = password;
	  }

	  public String getConfirmPassword() {
		  return confirmPassword;
	  }

	  public void setConfirmPassword(String confirmPassword) {
		  this.confirmPassword = confirmPassword;
	  }

	  public AddressDTO getAddress() {
		  return address;
	  }

	  public void setAddress(AddressDTO address) {
		  this.address = address;
	  }
	  
	  

}
