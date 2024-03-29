package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.model.User;
//import com.uco.tfg.app.model.HomeParticipant;
import com.uco.tfg.app.repository.HomeRepository;
import com.uco.tfg.app.repository.UserRepository;

@Service
public class HomeService {

	@Autowired
	private HomeRepository homeRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Home create(Home home) {
		return homeRepository.save(home);
	}

	public List<Home> getAllHomes() {
		return homeRepository.findAll();
	}

	public void delete(Home home) {
		homeRepository.delete(home);
	}

	public Optional<Home> findById(Long id) {
		return homeRepository.findById(id);
	}
	
	public boolean addParticipant(Long userId, Long homeId) {
		return homeRepository.addParticipant(userId,homeId);
	}
	
	public Home findMyHome(Long userId) {
		return homeRepository.findMyHome(userId);
	}
}
