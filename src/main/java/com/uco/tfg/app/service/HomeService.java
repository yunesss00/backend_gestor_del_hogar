package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.repository.HomeRepository;

@Service
public class HomeService {

	@Autowired
	private HomeRepository homeRepository;

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
}
