package com.mateus.service;

import java.util.List;

import com.mateus.model.Categoria;

public interface ICategoriaService {
	
	void salvar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);

}
