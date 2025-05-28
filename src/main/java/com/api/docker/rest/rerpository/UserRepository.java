package com.api.docker.rest.rerpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.docker.rest.dto.UserDTO;
import com.api.docker.rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	 

}
