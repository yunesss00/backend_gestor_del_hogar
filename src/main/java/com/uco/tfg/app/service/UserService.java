package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uco.tfg.app.model.User;
import com.uco.tfg.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public User findByEmail(String email) throws Exception{
		
			return  userRepository.findByEmail(email);
		
	}
	
	public List<User> getHomeParticipants(Long homeId) {
        return userRepository.getHomeParticipants(homeId);
    }
	
}
