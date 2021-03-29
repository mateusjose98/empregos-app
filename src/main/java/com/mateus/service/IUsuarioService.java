package com.mateus.service;

import java.util.List;

import com.mateus.model.Usuario;

public interface IUsuarioService {
	
	void salvar(Usuario usuario);
	
	void deletar(Integer idUsuario);
	
	List<Usuario> buscarTodos();

}
