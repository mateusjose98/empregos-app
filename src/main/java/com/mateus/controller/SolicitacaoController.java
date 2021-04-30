package com.mateus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mateus.model.Solicitacao;

@Controller
@RequestMapping("solicitar")
public class SolicitacaoController {
	


	
	@PostMapping("/{id}")
	public String solicitar(@PathVariable("id") Integer idVaga, Solicitacao solicitacao, 
							@RequestParam("file") MultipartFile multiPart) {
		
		
		return null;
		
	}
}
