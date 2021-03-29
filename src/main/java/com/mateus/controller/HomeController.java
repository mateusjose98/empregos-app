package com.mateus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Perfil;
import com.mateus.model.Usuario;
import com.mateus.model.Vaga;
import com.mateus.service.IUsuarioService;
import com.mateus.service.IVagasService;

@Controller
public class HomeController {
	@Autowired
	private IVagasService serviceVagas;
	
	@Autowired
	private IUsuarioService userService;
	

	
	@GetMapping("/usuarios/singup")
	public String registrarSe(Usuario usuario) {
		return "usuarios/formRegistro";
	}
	
	
	@PostMapping("/usuarios/singup")
	public String salvarRegistro(Usuario usuario, RedirectAttributes redirect) {
	
		userService.salvar(usuario);
		redirect.addFlashAttribute("msg", "Usuario cadastrado!");
		return "redirect:/usuarios/index";
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
	


	@GetMapping("/")
	public String mostrarHome(Model model) {
		return "home";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("vagas", serviceVagas.buscarDestaques());		
	}
	
	
	
	
}
