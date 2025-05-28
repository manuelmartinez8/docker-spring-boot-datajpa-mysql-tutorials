package com.api.docker.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.docker.rest.dto.UserDTO;
import com.api.docker.rest.dto.UserSignupRequest;
import com.api.docker.rest.service.UserService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	  @PostMapping("/signup")
	  public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserSignupRequest signUpRequest) {
		  try {
			  return new ResponseEntity<>(service.createUser(signUpRequest), HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @GetMapping("/users")
	  public ResponseEntity<List<UserDTO>> getAllUser(@RequestParam(required = false) String username){
		  try {
			  List<UserDTO> userList = service.findAll(username);
			  
			  if(userList.isEmpty()) {
				  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  }
			  return new ResponseEntity<>(userList ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		  
	  }
	  

}
