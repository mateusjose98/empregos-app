package com.mateus.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utilitario {
	
	public static String salvarArquivo(MultipartFile multiPart, String rota) {
			// obter o nome original do arquivo recebido
			String nomeOriginal = multiPart.getOriginalFilename();
			nomeOriginal.replace(" ", "-");
			String nomeFinal = randomAlphaNumeric(8) + nomeOriginal;
			
		try {
			// Formar o nome do arquivo para guardar no HD
			File imageFile = new File(rota + nomeFinal);
			System.out.println("Arquivo: " + imageFile.getAbsolutePath());
			//Guardar no HD
			multiPart.transferTo(imageFile);
			return nomeFinal;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
		}
	
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		
		return builder.toString();
	}

}
