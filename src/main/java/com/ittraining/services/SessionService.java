package com.ittraining.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ittraining.dto.FormationDTO;
import com.ittraining.dto.SessionDTO;
import com.ittraining.entities.Administrateur;
import com.ittraining.entities.Formation;
import com.ittraining.entities.Session;
import com.ittraining.repositories.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;
	
	@Autowired
	private FormationService formationService;
	
	public Session save(SessionDTO sessionDTO) {	
		Session entity = this.convertToEntity(sessionDTO);
		return repository.save(entity);
	}

	public List<SessionDTO> findAll() {
		return ((List<Session>) repository.findAll()).stream().map(this::convertToSessionDto)
				.collect(Collectors.toList());
	}

	public Session findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	
	public SessionDTO findByIdToDTO(Long id) {
		Session session = this.findById(id);
		SessionDTO sessionDto = new SessionDTO();
		sessionDto.setId(session.getId());
		sessionDto.setDateDebut(session.getDate_debut());
		sessionDto.setDateFin(session.getDate_fin());
		sessionDto.setPrix(session.getPrix());
		sessionDto.setLieu(session.getLieu());
		return sessionDto;
	}
	

	private SessionDTO convertToSessionDto(Session session) {
		SessionDTO sessionDto = new SessionDTO();
		sessionDto.setId(session.getId());
		sessionDto.setDateDebut(session.getDate_debut());
		sessionDto.setDateFin(session.getDate_fin());
		sessionDto.setPrix(session.getPrix());
		sessionDto.setLieu(session.getLieu());
		
		FormationDTO formationDTO = this.formationService.convertToFormation(session.getFormation());
		sessionDto.setFormation(formationDTO);
		return sessionDto;
	}
	
	private Session convertToEntity(SessionDTO sessionDTO) {
		Session session = new Session();
		session.setDate_debut(sessionDTO.getDateDebut());
		session.setDate_fin(sessionDTO.getDateFin());
		session.setPrix(sessionDTO.getPrix());
		session.setLieu(sessionDTO.getLieu());
		
		Formation formation = this.formationService.convertToEntity(sessionDTO.getFormation());
		session.setFormation(formation);
		return session;
	}
	
	public List<Session> findByFormationId(Long id) {
		return repository.findByFormationId(id);
	}

	public List<SessionDTO> findByFormationIdDTO(Long id) {
		return ((List<Session>)repository
				.findByFormationId(id))
				.stream()
				.map(this::convertToSessionDto)
							.collect(Collectors.toList());
	}
	
	public void deleteById(Long id) {
		Optional<Session> sessionOptional = this.repository.findById(id);
		if (sessionOptional.isPresent()) 
			this.repository.deleteById(id);
	}

}
