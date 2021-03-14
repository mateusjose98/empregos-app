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
		vaga.setNome("Programador Senior");
		vaga.setDescricao("Vaga PJ Junior");
		vaga.setDescricao("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum");
		vaga.setSalario(9300.00);
		vaga.setStatus("Criada");
		vaga.setData(new Date());
		vaga.setImagem("devmidia.png");
		vaga.setDestacado(1);
		
		
		
		Vaga vaga2 = new Vaga();
		vaga2.setId(2);
		vaga2.setNome("Analista");
		vaga2.setDescricao("E vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum");
		vaga2.setSalario(3000.00);
		vaga2.setData(new Date());
		vaga2.setDestacado(0);
		vaga2.setImagem("vale.png");
		vaga2.setStatus("Criada");
		
		Vaga vaga3 = new Vaga();
		vaga3.setId(3);
		vaga3.setNome("Assistente de TI");
		vaga3.setDescricao("Vaga PJ Junior");
		vaga3.setSalario(2400.00);
		vaga3.setData(new Date());
		vaga3.setDestacado(0);
		vaga3.setImagem("vivo.png");
		vaga3.setStatus("Aprovada");
		
		
		Vaga vaga4 = new Vaga();
		vaga4.setId(4);
		vaga4.setNome("Suporte Jr");
		vaga4.setDescricao("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum");
		vaga4.setSalario(2000.00);
		vaga4.setData(new Date());
		vaga4.setDestacado(1);
		vaga4.setImagem("coca.png");
		vaga4.setStatus("Eliminada");
		
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


	@Override
	public void salvar(Vaga vaga) {
		this.vagas.add(vaga);
	}

}
