package com.mateus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.model.Vaga;

public interface VagasRepository extends JpaRepository<Vaga, Integer> {

	
	List<Vaga> findByStatus(String status);
}
