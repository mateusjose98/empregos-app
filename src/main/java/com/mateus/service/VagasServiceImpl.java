package com.mateus.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mateus.model.Vaga;


@Service
public class VagasServiceImpl implements IVagasService{
	
	private List<Vaga> vagas = null;
	
	public VagasServiceImpl() {
		
		this.vagas = new LinkedList<>();
		
		Vaga vaga = new Vaga();
		vaga.setId(1);
		vaga.setNome("Programador");
		vaga.setDescricao("Vaga PJ Junior");
		vaga.setSalario(5000.00);
		vaga.setData(new Date());
		vaga.setDestacado(1);
		vaga.setImagem("empresa1.png");
		
		Vaga vaga2 = new Vaga();
		vaga2.setId(2);
		vaga2.setNome("Programador");
		vaga2.setDescricao("Vaga PJ Junior");
		vaga2.setSalario(5000.00);
		vaga2.setData(new Date());
		vaga2.setDestacado(0);
		vaga.setImagem("empresa2.png");
		
		Vaga vaga3 = new Vaga();
		vaga3.setId(3);
		vaga3.setNome("Programador");
		vaga3.setDescricao("Vaga PJ Junior");
		vaga3.setSalario(5000.00);
		vaga3.setData(new Date());
		vaga3.setDestacado(0);
		
		
		Vaga vaga4 = new Vaga();
		vaga4.setId(4);
		vaga4.setNome("Programador");
		vaga4.setDescricao("Vaga PJ Junior");
		vaga4.setSalario(5000.00);
		vaga4.setData(new Date());
		vaga4.setDestacado(1);
		vaga4.setImagem("empresa1.png");
		
		vagas.add(vaga);
		vagas.add(vaga2);
		vagas.add(vaga3);
		vagas.add(vaga4);
		
	}
	

	@Override
	public List<Vaga> buscarTodas() {
		return this.vagas;
	}


	@Override
	public Vaga buscarPorId(Integer id) {
		
		for (Vaga vg : this.vagas) {
			if(vg.getId() == id) {
				return vg;
			}
		}
		
		return null;
	}

}
