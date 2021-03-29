package com.mateus.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mateus.model.Vaga;

public interface IVagasService {
	
	List<Vaga> buscarTodas();
	
	List<Vaga> buscarDestaques();
	
	Vaga buscarPorId(Integer id);
	
	void deletar(Integer id);
	
	void salvar(Vaga vaga);
	
	List<Vaga> buscarByExemplo(Example<Vaga> exemple);
	
	Page<Vaga> buscarTodas(Pageable page);

}
