package com.ittraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ittraining.dto.SessionDTO;
import com.ittraining.entities.Session;
import com.ittraining.services.SessionService;

@RestController
@CrossOrigin
@RequestMapping("session")
public class SessionController {

	@Autowired
	private SessionService service;


	@PostMapping("")
	public Session save(@RequestBody SessionDTO sessionDTO) {
		return service.save(sessionDTO);
	}

	@GetMapping("")
	public List<SessionDTO> findAll() {
		return service.findAll();
	}

//	@GetMapping("{id}")
//	public Session findById(@PathVariable Long id) {
//		return service.findById(id);
//	}
	
	@GetMapping("{id}")
	public List<SessionDTO> findByFormationId(@PathVariable Long id) {
		List<SessionDTO> sessionDTO = this.service.findByFormationIdDTO(id);
		return sessionDTO;
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		this.service.deleteById(id);
	}
	
}
