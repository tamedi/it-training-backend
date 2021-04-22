package com.ittraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.entities.Formateur;
import com.ittraining.repositories.FormateurRepository;

@Service
public class FormateurService {

	@Autowired
	private FormateurRepository repository;

	public Formateur save(Formateur entity) {
		return repository.save(entity);
	}

	public List<Formateur> findAll() {
		return repository.findAll();
	}

	public List<Formateur> findByNom(String nom) {
		return repository.findByNom(nom);
	}

	public List<Formateur> findByNote(int note) {
		return repository.findByNote(note);
	}

	public Formateur findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
}