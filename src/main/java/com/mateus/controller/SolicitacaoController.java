package com.mateus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mateus.model.Solicitacao;
import com.mateus.model.Usuario;
import com.mateus.service.IUsuarioService;
import com.mateus.service.IVagasService;
import com.mateus.service.SolicitacaoService;
import com.mateus.util.Utilitario;

@Controller
@RequestMapping("solicitacao")
public class SolicitacaoController {
	


	@Autowired
	public SolicitacaoService repository;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private IVagasService serviceVagas;
	
	@PostMapping("/{id}")
	public String solicitar(@PathVariable("id") Integer idVaga,
							Solicitacao solicitacao, 
							RedirectAttributes attributes,
							@RequestParam("cv") MultipartFile multiPart, Authentication auth) {

		
		
		Usuario us = userService.buscarPorUserName(auth.getName());
		
		if (!multiPart.isEmpty()) {
			String rota = "/mnt/55C53C1C3294C6DA/Projetos Java/udemy-spring-mvc/empregos/src/main/resources/static/imagens/";
			
			String nomeArquivo = Utilitario.salvarArquivo(multiPart, rota);
			if (nomeArquivo != null){ // O upload foi feito
			
				solicitacao.setArquivo(nomeArquivo);
				solicitacao.setData_aplicacao(new Date());
				solicitacao.setUsuario(us);
				solicitacao.setVaga(serviceVagas.buscarPorId(idVaga));
				
				System.out.println(idVaga);
				System.out.println(multiPart.getOriginalFilename());
				System.out.println(solicitacao);
				
				repository.salvar(solicitacao);
				
				attributes.addFlashAttribute("msg", "Solicitação realizada com sucesso!");
				
				return "redirect:/";
				
				
			}
		}
		
		
		attributes.addFlashAttribute("msg", "Solicitação NÃO realizada!");
		return "redirect:/";
		
	}
	

}
