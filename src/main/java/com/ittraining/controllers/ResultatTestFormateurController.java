package com.ittraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.entities.ResultatTestFormateur;
import com.ittraining.services.ResultatTestFormateurService;

@RestController
@RequestMapping("resultat test formateur")
@CrossOrigin
public class ResultatTestFormateurController {
	
	@Autowired
	private ResultatTestFormateurService service;
	
	@PostMapping("")
	public ResultatTestFormateur save(@RequestBody ResultatTestFormateur entity) {
		return this.service.save(entity);
	}
	
	@GetMapping("{id}")
	public ResultatTestFormateur findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
