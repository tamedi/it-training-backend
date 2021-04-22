package com.ittraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.entities.TestFormateur;
import com.ittraining.repositories.TestFormateurRepository;

@Service
public class TestFormateurService {
	
	@Autowired
	private TestFormateurRepository repository;

	public TestFormateur save(TestFormateur entity) {
		return repository.save(entity);
	}

	public List<TestFormateur> findAll() {
		return repository.findAll();
	}

	public List<TestFormateur> findByTitre(String titre) {
		return repository.findByTitre(titre);
	}

	public TestFormateur findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
}

