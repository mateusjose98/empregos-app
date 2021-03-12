package com.mateus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vagas")
public class VagasController {

	@GetMapping("/view/{id}")
	public String verDetalhe(@PathVariable("id") Integer idVaga, Model model) {
		System.out.println("valor id vaga: " + idVaga);
		model.addAttribute("id", idVaga);
		
		//Buscar os detalhes da vaga na base de dados
		return "vagas/detalhe";
	}
}
