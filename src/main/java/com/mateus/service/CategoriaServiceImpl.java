package com.mateus.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mateus.model.Categoria;


@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	private List<Categoria> listaCategorias;
	
	
	public CategoriaServiceImpl(){
		
		this.listaCategorias = new LinkedList<>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNome("Vendas");
		c1.setDescricao("uma categoria legal");
		
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNome("Contrabando");
		c2.setDescricao("uma categoria legal");
		
		Categoria c3 = new Categoria();
		c3.setId(1);
		c3.setNome("TI");
		c3.setDescricao("uma categoria legal");
		
		Categoria c4 = new Categoria();
		c4.setId(4);
		c4.setNome("Mostruario");
		c4.setDescricao("uma categoria legal");
		
		listaCategorias.add(c1);
		listaCategorias.add(c2);
		listaCategorias.add(c3);
		listaCategorias.add(c4);
		
		
	}
	
	

	@Override
	public void salvar(Categoria categoria) {
		this.listaCategorias.add(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		return this.listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		for(Categoria cat : listaCategorias) {
			if(cat.getId() == idCategoria) {
				return cat;
			}
		}
		
		return null;
	}



	@Override
	public Boolean deletar(Integer idCategoria) {
		return true;
		
	}

}
