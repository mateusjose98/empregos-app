package com.mateus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mateus.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("usuarios", userService.buscarTodos());
		return "usuarios/listUsuarios";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		userService.deletar(id);
		return "redirect:/usuarios/index";
	}
	
}
