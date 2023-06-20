package com.example.userservice.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.dto.UserToUserDTOMapper;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.users.User;

@Service
public class UserService {

	private UserRepository userRepository;
	private RestTemplate restTemplate;
	
	@Autowired
	public UserService(UserRepository userRepository, RestTemplate restTemplate) {
		super();
		this.userRepository = userRepository;
		this.restTemplate = restTemplate;
	}
	
	
	
	public User addUser(UserDTO userDTO) {
		User userEntity = new User(userDTO.fullname(),
				userDTO.email(),
				userDTO.password());
		userRepository.save(userEntity);
		return userEntity;
	}

	public List<UserResponseDTO> getAllUser() {
		List<UserResponseDTO> users = new ArrayList<UserResponseDTO>();
		this.userRepository.findAll().forEach( user -> users.add(new UserToUserDTOMapper().apply(user))) ;	
		return users;
	}
	
	public UserResponseDTO ByEmail(String email) {
		 Optional<User> user = userRepository.ByEmail(email);	
		 if(user.isPresent()) {
			 return new UserToUserDTOMapper().apply(user.get());
			 
		 }
		return null;
	}
	
	
	public void getUserDetailsById(String userId) {
//		this.restTemplate.getForEntity(BOOKHOST+"/getById", null)
	}

}
