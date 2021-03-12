package com.mateus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mateus.service.IVagasService;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private IVagasService serviceVagas;

	@GetMapping("/view/{id}")
	public String verDetalhe(@PathVariable("id") Integer idVaga, Model model) {
		
		model.addAttribute("vaga", serviceVagas.buscarPorId(idVaga));
		
		//Buscar os detalhes da vaga na base de dados
		return "vagas/detalhe";
	}
}
