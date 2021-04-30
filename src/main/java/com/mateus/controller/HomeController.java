package com.mateus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		return "home";
	}
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityContextLogoutHandler logoutHandler =
		new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}

	
	@GetMapping("/usuarios/singup")
	public String registrarSe() {
		return "usuarios/formRegistro";
	}
	
	
	@PostMapping("/usuarios/singup")
	public String salvarRegistro(Usuario usuario, RedirectAttributes redirect) {
	
		String pass = usuario.getPassword();
		String passEncriptado = passwordEncoder.encode(pass);
		
		System.out.println(passwordEncoder.encode("12345"));
		
		usuario.setPassword(passEncriptado);
		userService.salvar(usuario);
		redirect.addFlashAttribute("msg", "Usuário " + usuario.getNome() +" foi cadastrado!");
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		String userName = auth.getName();
		
		if(session.getAttribute("usuario") == null) {
			Usuario us = userService.buscarPorUserName(userName);
			us.setPassword(null);
			session.setAttribute("usuario", us);
			System.out.println(us);
		}
		return "redirect:/";
	}
	
	
	
	
	//Busca da tela inicial por descrição ou por categorias
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Vaga vaga, Model model) {
		
		ExampleMatcher matcher = ExampleMatcher.matching() // where descricao like '%?%', este método pode ser melhorado (@Query)
												.withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<Vaga> example = Example.of(vaga, matcher);
		
		List<Vaga> lista = serviceVagas.buscarByExemplo(example);
		
		model.addAttribute("vagas", lista ); //lista de vagas é passada para o Model e renderizada em "home"
		
		return "home";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	
	@ModelAttribute // objetos iniciais
	public void setGenericos(Model model) {
		Vaga vaga = new Vaga();
		vaga.reset();
		model.addAttribute("search", vaga);
		model.addAttribute("vagas", serviceVagas.buscarDestaques());		
		model.addAttribute("categorias", serviceCategoria.buscarTodas());
		model.addAttribute("usuario",new Usuario());
	}
	
	
	
	
}
