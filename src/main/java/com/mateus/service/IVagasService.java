package com.mateus.service;

import java.util.List;

import com.mateus.model.Vaga;

public interface IVagasService {
	
	List<Vaga> buscarTodas();
	
	List<Vaga> buscarDestaques();
	
	Vaga buscarPorId(Integer id);
	
	void deletar(Integer id);
	
	void salvar(Vaga vaga);

}
