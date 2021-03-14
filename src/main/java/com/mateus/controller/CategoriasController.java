package com.mateus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@GetMapping("/deletar")
	public String excluir(@RequestParam("id") int idVaga, Model model) {
		System.out.println(idVaga);
		model.addAttribute("id", idVaga);
		return "mensagem";
		
	}
	

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String criar() {
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(@RequestParam("nome") String nome,@RequestParam("descricao") String descricao) {
		System.out.println("Categoria: " + nome);
		System.out.println("Categoria: " + descricao);
		
		return "categorias/listCategorias";
	}
	
}
