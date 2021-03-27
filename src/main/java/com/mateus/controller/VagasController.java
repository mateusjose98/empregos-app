package com.mateus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Vaga;
import com.mateus.service.ICategoriaService;
import com.mateus.service.IVagasService;
import com.mateus.util.Utilitario;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Value("${empregos.rota.imagens}")
	private String rota;
	
	@Autowired
	private IVagasService serviceVagas;
	
	@Autowired
	private ICategoriaService serviceCategorias;
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		
	}
	
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
	
	

	@PostMapping("/save")
	public String salvar(Vaga vaga, 
						BindingResult result, 
						RedirectAttributes attributes,
						@RequestParam("arquivoImagem") MultipartFile multiPart) {
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocorreu um erro: " + error.getDefaultMessage());
			}
			
			return "vagas/formVagas";
		}
		
		if (!multiPart.isEmpty()) {
			String rota = this.rota;
			
			String nomeImagem = Utilitario.salvarArquivo(multiPart, rota);
			if (nomeImagem != null){ // O upload foi feito
			// Temos a imagem nomeImagem disponivel para salvar
				vaga.setImagem(nomeImagem);
			}
		}
		
		serviceVagas.salvar(vaga);
		attributes.addFlashAttribute("msg", "REGISTRADO!");
		return "redirect:/vagas/index";
	}
	
	
	@GetMapping("/criar")
	public String criar(Vaga vaga, Model model) {
		return "vagas/formVagas";
	}


	@GetMapping("/view/{id}")
	public String verDetalhe(@PathVariable("id") Integer idVaga, Model model) {
		
		model.addAttribute("vaga", serviceVagas.buscarPorId(idVaga));
		
		//Buscar os detalhes da vaga na base de dados
		return "vagas/detalhe";
	}
	
	
	@GetMapping("/deletar/{idVaga}")
	public String deletar(@PathVariable("idVaga") int idVaga, RedirectAttributes redirect) {
		serviceVagas.deletar(idVaga);
		redirect.addFlashAttribute("msg", "Vaga excluída!");
		return "redirect:/vagas/index";
	}
	
	
	@GetMapping("/editar/{idVaga}")
	public String editar(@PathVariable("idVaga") int id, Model model) {
		model.addAttribute("vaga", serviceVagas.buscarPorId(id));
		return "vagas/formVagas";
	}
	
	
	
	
}
