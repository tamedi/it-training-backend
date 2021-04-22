package com.ittraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.entities.ResultatTestFormateur;
import com.ittraining.repositories.ResultatTestFormateurRepository;

@Service
public class ResultatTestFormateurService {

	@Autowired
	private ResultatTestFormateurRepository repository;

	public ResultatTestFormateur save(ResultatTestFormateur entity) {
		return repository.save(entity);
	}

	public List<ResultatTestFormateur> findAll() {
		return repository.findAll();
	}

	public ResultatTestFormateur findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
	

}
