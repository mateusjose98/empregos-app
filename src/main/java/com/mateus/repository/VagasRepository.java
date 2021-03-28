package com.mateus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateus.model.Categoria;
import com.mateus.model.Vaga;

public interface VagasRepository extends JpaRepository<Vaga, Integer> {

	
	List<Vaga> findByStatus(String status);

	@Query(value = "select * from Vaga v where v.status = 'Aprobada' and v.destacado = 1 order by v.data desc", nativeQuery=true)
	List<Vaga> findByDestaquesStatusDesc();

	Integer countByCategoria(Categoria categoria);
}
