package com.ittraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ittraining.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

	public List <Theme> findByNom(String nom);
	
	public List<Theme> findByDescription(String description);
	
}
 