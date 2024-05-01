package com.uco.tfg.app.service;


import java.util.List;
import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.model.User;
//import com.uco.tfg.app.model.HomeParticipant;
import com.uco.tfg.app.repository.HomeRepository;
import com.uco.tfg.app.repository.UserRepository;

import jakarta.transaction.Transactional;

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
	 @Transactional
	public int addParticipant(Long userId, Long homeId) {
		return homeRepository.addParticipant(userId,homeId);
	}
	
	public Home findMyHome(Long userId) {
		return homeRepository.findMyHome(userId);
	}

	public boolean inviteUser(String email, Long homeId, Long userId) {
		return homeRepository.inviteUser(email,homeId,userId);
	}

	 @Transactional
	public int updateInvitation(String email, Long homeId, int accepted) {
		return homeRepository.updateInvitation(email,homeId, accepted);

	}

	public List<Home> getInvitations(String email) {
		 List<Home> listHomes = new ArrayList<>(); // Cambiado a ArrayList en lugar de Optional
		    List<Long> listHomeInt = homeRepository.getInvitations(email);
		    
		    for (Long homeId : listHomeInt) {
		        Optional<Home> optionalHome = homeRepository.findById(homeId);
		        optionalHome.ifPresent(listHomes::add); // Agrega el objeto Home si está presente en el Optional
		    }
		    
		    return listHomes; 
	}
	 @Transactional
	public void setCurrentHome(Long userId, Long homeId) {
		 homeRepository.setCurrentHome(userId,homeId);
	}

	public List<Home> findMyHomes(Long userId) {
		return homeRepository.findMyHomes(userId);
	}
}
