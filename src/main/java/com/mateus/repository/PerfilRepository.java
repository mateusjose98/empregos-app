package com.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

	Perfil findByPerfil(String string);

}
