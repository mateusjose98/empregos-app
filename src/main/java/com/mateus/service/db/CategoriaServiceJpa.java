package com.mateus.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mateus.model.Categoria;
import com.mateus.repository.CategoriaRepository;
import com.mateus.repository.VagasRepository;
import com.mateus.service.ICategoriaService;

@Primary
@Service
public class CategoriaServiceJpa implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private VagasRepository vagaRepo;
	
	
	@Override
	public void salvar(Categoria categoria) {
		categoriaRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> obj = categoriaRepo.findById(idCategoria);
		return obj.isPresent() ? obj.get() : null;
	}

	@Override
	public Boolean deletar(Integer idCategoria){
		Optional<Categoria> c =  categoriaRepo.findById(idCategoria);
		Integer qtePresente = vagaRepo.countByCategoria(c.get());
		
		if(idCategoria != null && qtePresente == 0) {
			 
			categoriaRepo.deleteById(idCategoria);	
			return true;
		}
		return false;
		
	}

}
