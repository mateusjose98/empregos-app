package com.mateus.service;

import java.util.List;

import com.mateus.model.Vaga;

public interface IVagasService {
	
	List<Vaga> buscarTodas();
	
	Vaga buscarPorId(Integer id);

}
