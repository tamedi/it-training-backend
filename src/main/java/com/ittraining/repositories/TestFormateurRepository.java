package com.ittraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.TestFormateur;

public interface TestFormateurRepository extends JpaRepository<TestFormateur, Long> {
	
	public List<TestFormateur> findByTitre(String titre);

}
