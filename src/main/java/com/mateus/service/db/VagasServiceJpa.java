package com.mateus.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mateus.model.Vaga;
import com.mateus.repository.VagasRepository;
import com.mateus.service.IVagasService;

@Primary
@Service
public class VagasServiceJpa implements IVagasService {
	
	@Autowired
	private VagasRepository vagaRepo;

	@Override
	public List<Vaga> buscarTodas() {
		// TODO Auto-generated method stub
		return vagaRepo.findAll();
	}

	@Override
	public Vaga buscarPorId(Integer id) {
		Optional<Vaga> vagas = vagaRepo.findById(id);
		return vagas.isPresent() ? vagas.get() : null;
	}

	@Override
	public void salvar(Vaga vaga) {

		vagaRepo.save(vaga);
	}

	@Override
	public List<Vaga> buscarDestaques() {
		
		return vagaRepo.findByDestaquesStatusDesc();
	}

	@Override
	public void deletar(Integer id) {
		vagaRepo.deleteById(id);
		
	}

}
