package com.ittraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.entities.TestFormateur;
import com.ittraining.services.TestFormateurService;

@RestController
@RequestMapping("test_formateur")
@CrossOrigin
public class TestFormateurController {

	@Autowired
	private TestFormateurService service;

	@PostMapping("")
	public TestFormateur save(@RequestBody TestFormateur entity) {
		return this.service.save(entity);
	}

	@GetMapping("titre/{titre}")
	public List<TestFormateur> findByTitre(@PathVariable String titre) {
		return service.findByTitre(titre);

	}
	
	@GetMapping("{id}")
	public TestFormateur findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
