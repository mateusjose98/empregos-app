package com.mateus.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mateus.model.Vaga;

@Controller
public class HomeController {
	

	
	@GetMapping("/tabela")
	public String tabelaVagas(Model model) {
		
		List<Vaga> vagas = new LinkedList<>();
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
		
		
		
		model.addAttribute("vagas", vagas);
		
		return "vagas";
		
		
		
		
	}
	
	
	
	@GetMapping("/detalhes")
	public String mostrarDetalhes(Model model) {
		Vaga vaga = new Vaga();
		vaga.setNome("Programador");
		vaga.setDescricao("Vaga PJ Junior");
		vaga.setSalario(5000.00);
		vaga.setData(new Date());
		model.addAttribute("vaga", vaga);
		
		return "detalhe";
	}
	
	
	@GetMapping("/lista")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		lista.add("Programador PHP");
		lista.add("Analista de Sistemas Java");
		lista.add("Data Science - Python");
		
		model.addAttribute("empregos", lista);
		
		return "listados";
	}

	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		/*
		model.addAttribute("mensagem","José Mateus");
		model.addAttribute("dataAtual", new Date());
		*/
		String nome = "Programador";
		Date dPub = new Date();
		double salario = 10000;
		boolean disponivel = true;
		model.addAttribute("nome", nome);
		model.addAttribute("salario", salario);
		
		return "home";
	}
}
