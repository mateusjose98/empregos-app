package com.mateus.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.model.Perfil;
import com.mateus.model.Usuario;
import com.mateus.repository.PerfilRepository;
import com.mateus.repository.UsuarioRepository;
import com.mateus.service.IUsuarioService;


@Service
public class UsuarioServiceJpa implements IUsuarioService{
	
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private PerfilRepository perfilRepo;
	
	

	@Override
	public void salvar(Usuario usuario) {
		Perfil perfilPadrao = perfilRepo.findByPerfil("USUÁRIO");
		usuario.agregarPerfilaUsuario(perfilPadrao);
		userRepo.save(usuario);
	}

	@Override
	public void deletar(Integer idUsuario) {
		userRepo.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		return userRepo.findAll();
	}

}
