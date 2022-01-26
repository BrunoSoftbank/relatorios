package br.com.softbank.relatorios.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softbank.relatorios.service.PdfService;

@RestController
@RequestMapping("/clubes")
public class ClubesController {
	
	@Autowired
	private PdfService service;
	
	@GetMapping("/pdf")
	public void findAll(HttpServletResponse response) throws Exception {
		service.gerarRelatorio(response);
		response.getOutputStream().close();
	}

}
