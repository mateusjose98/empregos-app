package com.mateus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Categoria;
import com.mateus.service.ICategoriaService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService serviceCategoria;
		
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		model.addAttribute("categorias", serviceCategoria.buscarTodas());
		return "categorias/listCategorias";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String criar(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(Categoria categoria, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			for (ObjectError e : result.getAllErrors()) {
				System.out.println("Ocorreu um erro: " + e.getDefaultMessage());
			}
			return "categorias/formCategoria";
		}
		System.out.println(categoria);
		redirect.addFlashAttribute("sucesso", "Categoria registrada!");
		serviceCategoria.salvar(categoria);
		
		return "redirect:/categorias/index";
	}
	
}
