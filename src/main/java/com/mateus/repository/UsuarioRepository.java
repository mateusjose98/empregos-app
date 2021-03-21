package com.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
