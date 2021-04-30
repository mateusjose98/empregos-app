package com.mateus.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mateus.model.Categoria;
import com.mateus.model.Solicitacao;
import com.mateus.repository.SolicitacaoRepository;

@Primary
@Service
public class SolicitacaoServiceJpa{

	@Autowired
	private SolicitacaoRepository repository;
	
	
	public void salvar(Solicitacao categoria) {
		repository.save(categoria);
	}


	public List<Solicitacao> buscarTodas() {
		return repository.findAll();
	}


	public Solicitacao buscarPorId(Integer idSolicitacao) {
		Optional<Solicitacao> obj = repository.findById(idSolicitacao);
		return obj.isPresent() ? obj.get() : null;
	}

	

}
