package com.mateus.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Usuario;
import com.mateus.model.Vaga;
import com.mateus.service.ICategoriaService;
import com.mateus.service.IUsuarioService;
import com.mateus.service.IVagasService;

@Controller
public class HomeController {
	@Autowired
	private IVagasService serviceVagas;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private ICategoriaService serviceCategoria;
	

	
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
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Vaga vaga, Model model) {
		System.out.println(vaga);
		ExampleMatcher matcher = ExampleMatcher.matching() // where descricao like '%?%'
												.withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<Vaga> example = Example.of(vaga, matcher);
		List<Vaga> lista = serviceVagas.buscarByExemplo(example);
		model.addAttribute("vagas", lista );
		return "home";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Vaga vaga = new Vaga();
		vaga.reset();
		model.addAttribute("search", vaga);
		model.addAttribute("vagas", serviceVagas.buscarDestaques());		
		model.addAttribute("categorias", serviceCategoria.buscarTodas());
	}
	
	
	
	
}
