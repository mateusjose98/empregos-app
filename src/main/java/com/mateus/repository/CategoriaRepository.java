package com.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
