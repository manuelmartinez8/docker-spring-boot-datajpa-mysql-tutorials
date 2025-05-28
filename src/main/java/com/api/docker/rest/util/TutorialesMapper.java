package com.api.docker.rest.util;

import java.util.List;
import java.util.stream.Collectors;

 
import com.api.docker.rest.dto.AddressDTO;
import com.api.docker.rest.dto.TutorialDTO;
//import com.api.docker.rest.dto.TutorialDTO;
import com.api.docker.rest.dto.UserDTO;
import com.api.docker.rest.model.Tutorial;
//import com.api.docker.rest.model.Tutorial;
import com.api.docker.rest.model.User;

public class TutorialesMapper {
	
	public static TutorialDTO toDto(Tutorial tutorial) {
		
		return new TutorialDTO(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished());
	}
	
	public static List<TutorialDTO> toDtoList(List<Tutorial> tutorial){
		return tutorial.stream()
				.map(TutorialesMapper::toDto)
				.collect(Collectors.toList());		
	}
	
	public static UserDTO toUserDto(User user) {
		AddressDTO adto = new AddressDTO(user.getAddress().getCity(), user.getAddress().getStreet());
		
		UserDTO   _euser = new UserDTO(
				   user.getUsername(),
				   user.getEmail(),
				   user.getAge(),
				   user.getGraduationDate(),
				   null,
				   adto);
		return _euser;
	}
	
	public static List<UserDTO> toDtoListUser(List<User> user){
		return user.stream()
				.map(TutorialesMapper::toUserDto)
				.collect(Collectors.toList());		
	}

}
