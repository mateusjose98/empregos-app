package com.mateus.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mateus.model.Vaga;
import com.mateus.service.IVagasService;

@Controller
public class HomeController {
	@Autowired
	private IVagasService serviceVagas;
	
	@GetMapping("/tabela")
	public String tabelaVagas(Model model) {
		
		model.addAttribute("vagas", serviceVagas.buscarTodas());		
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
		
		model.addAttribute("vagas", serviceVagas.buscarTodas());		
		
		return "home";
	}
}
