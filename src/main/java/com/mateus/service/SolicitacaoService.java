package com.mateus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.model.Solicitacao;
import com.mateus.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService implements ISolicitacaoService{
	
	@Autowired
	public SolicitacaoRepository repository;

	@Override
	public void salvar(Solicitacao sol) {
		repository.save(sol);
		
	}

}
