package com.mateus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Vaga;
import com.mateus.service.IVagasService;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	
	@Autowired
	private IVagasService serviceVagas;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		List<Vaga> listaVagas = serviceVagas.buscarTodas();
		
		model.addAttribute("vagas", listaVagas);
		
		return "vagas/listVagas";
		
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}
	
	
//	@PostMapping("/save")
//	public String salvar(
//			@RequestParam("nome") String nome,
//			@RequestParam("descricao") String descricao,
//			@RequestParam("status") String status,
//			@RequestParam("data") String data,
//			@RequestParam("destacado") Integer destacado,
//			@RequestParam("salario") double salario,
//			@RequestParam("detalhes") String detalhes
//			) {
//		
//		System.out.println(nome);
//		System.out.println(descricao);
//		System.out.println(status);
//		System.out.println(data);
//		System.out.println(destacado);
//		System.out.println(salario);
//		System.out.println(detalhes);
//		return "vagas/listVagas";
//	}
	
	@PostMapping("/save")
	public String salvar(Vaga vaga, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocorreu um erro: " + error.getDefaultMessage());
			}
			
			return "vagas/formVagas";
		}
		serviceVagas.salvar(vaga);
		attributes.addFlashAttribute("msg", "REGISTRADO!");
		return "redirect:/vagas/index";
	}
	
	
	@GetMapping("/criar")
	public String criar(Vaga vaga) {
		return "vagas/formVagas";
	}


	@GetMapping("/view/{id}")
	public String verDetalhe(@PathVariable("id") Integer idVaga, Model model) {
		
		model.addAttribute("vaga", serviceVagas.buscarPorId(idVaga));
		
		//Buscar os detalhes da vaga na base de dados
		return "vagas/detalhe";
	}
}
