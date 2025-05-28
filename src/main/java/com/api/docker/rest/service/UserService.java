package com.api.docker.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import com.api.docker.rest.dto.AddressDTO;
import com.api.docker.rest.dto.UserDTO;
import com.api.docker.rest.dto.UserSignupRequest;
import com.api.docker.rest.model.User;
import com.api.docker.rest.model.UserAddress;
//import com.api.docker.rest.model.Address;
import com.api.docker.rest.rerpository.UserRepository;
import com.api.docker.rest.util.TutorialesMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserDTO createUser(UserSignupRequest user) {
		UserAddress _user = new UserAddress(user.getAddress().getCity(), user.getAddress().getStreet());
		if(user != null) {
			User _euser = new User(user.getUsername(),
								   user.getEmail(),
								   user.getAge(),
								   user.getGraduationDate(),
								   user.getPassword(),
								   _user);
			
		return TutorialesMapper.toUserDto(repository.save(_euser));	
		}
		return null;		
	}
	
	public List<UserDTO> findAll(String username){
		List<User> listaEUsuarios = new ArrayList<User>();
		
		if(username == null) {
			repository.findAll().forEach(listaEUsuarios::add);
		}/*else { queda pendiente la busqueda por un campo o nombre
			repository.findByUsers(username).forEach(listaEUsuarios::add);
		}	*/	
		return TutorialesMapper.toDtoListUser(listaEUsuarios);
	}
	
	public UserDTO findById(Long id) {
		Optional<User> userData = repository.findById(id);
		if(userData.isPresent()) {
			User _u = userData.get();
			AddressDTO adto = new AddressDTO(_u.getAddress().getCity(), _u.getAddress().getStreet());
			UserDTO dto = new UserDTO(
					_u.getUsername(),
					_u.getEmail(),
					_u.getAge(),
					_u.getGraduationDate(),
					null,
					adto);
			return dto;
		}		
		return null;
	}
	
	public UserDTO updateById(Long id, UserDTO userDto) {
		Optional<User> userData = repository.findById(id);
		if(userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(userDto.getUsername());
			_user.setEmail(userDto.getEmail());
			_user.setAge(userDto.getAge());
			_user.setGraduationDate(userDto.getGraduationDate());
			_user.setPassword(null);
			UserAddress _address = new   UserAddress(userDto.getAddress().getCity(), userDto.getAddress().getStreet());
			_user.setAddress(_address);
			return TutorialesMapper.toUserDto(repository.save(_user));
			//repository.save(_user);
			
			//UserDTO dto = TutorialesMapper.toUserDto(_user);
					
					/*new UserDTO(_u.getUsername(),
					_u.getEmail(),
					_u.getAge(),
					_u.getGraduationDate(),
					null,
					_u.getAddress());*/
			
		}		
		return null;
	}

 

}

