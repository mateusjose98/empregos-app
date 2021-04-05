package com.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mateus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
	@Query(value = "select * from Usuario where username = :username", nativeQuery = true)
	Usuario findBynomeUser(@Param("username")String username);

}
