package com.api.docker.rest.dto;

import java.util.Date;

public class UserDTO {
	
	private String username;
	private String email;
	private int age;
	private Date graduationDate;
	private AddressDTO address;	
	private String password; 
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 
	public UserDTO(String username, String email, int age, Date graduationDate,String password, AddressDTO address) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.graduationDate = graduationDate;
		this.address = address;
		this.password = password;
	}


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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 
}
